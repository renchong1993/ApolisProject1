package com.example.dbayproject

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.dbayproject.product.model.ProdData
import com.example.dbayproject.shoppingcart.model.CartProduct
import java.lang.Exception

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createCartProduct =
//            """CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_IMAGE TEXT, $KEY_PRICE FLOAT, $KEY_QTY INTEGER)""".trimIndent()
            "CREATE TABLE ${TABLE_NAME} (" +
                    "${KEY_ID} INTEGER PRIMARY KEY," +
                    "${KEY_NAME} TEXT," +
                    "${KEY_IMAGE} TEXT," +
                    "${KEY_PRICE} FLOAT," +
                    "${KEY_QTY} INTEGER)"

        db?.execSQL(createCartProduct)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        if (db != null) {
            onCreate(db)
        }
    }


    fun insertProduct(product: CartProduct): Long{

        val existsQTY = isExists(product)

        if (existsQTY == 0){
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(KEY_ID, product.Id)
            contentValues.put(KEY_NAME, product.Name)
            contentValues.put(KEY_IMAGE, product.Image)
            contentValues.put(KEY_PRICE, product.Price)
            contentValues.put(KEY_QTY, product.QTY)

            val success = db.insert(TABLE_NAME, null, contentValues)
            db.close()
            return success
        }
        else{
            return updateProduct(product, existsQTY).toLong()
        }
    }



    fun isExists(product: CartProduct): Int{
        val pid = product.Id
        val db = readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $KEY_ID = $pid"

        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: Exception){
            db.execSQL(selectQuery)
            return 0
        }
        var existsQTY: Int = 0
        if (cursor.moveToFirst()){
            try {
                existsQTY = cursor.getInt(cursor.getColumnIndexOrThrow("$KEY_QTY"))
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
        return existsQTY
    }


    fun updateProduct(product: CartProduct, qty: Int): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, product.Id)
        contentValues.put(KEY_NAME, product.Name)
        contentValues.put(KEY_IMAGE, product.Image)
        contentValues.put(KEY_PRICE, product.Price)
        contentValues.put(KEY_QTY, product.QTY+qty)

        val success = db.update(TABLE_NAME, contentValues,"ID = " + product.Id, null)
        db.close()

        return success
    }


    @SuppressLint("Recycle")
    fun getAllProducts(): ArrayList<CartProduct>{
        val cart: ArrayList<CartProduct> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase

        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: Exception){
            e.printStackTrace()
        }

        var prodID: Int
        var prodName: String
        var prodImage: String
        var prodPrice: Float
        var prodQTY: Int

        if(cursor!!.moveToFirst()){
            do{
//                try {
                    prodID = cursor.getInt(cursor.getColumnIndexOrThrow("$KEY_ID"))
                    prodName = cursor.getString(cursor.getColumnIndexOrThrow("$KEY_NAME"))
                    prodImage = cursor.getString(cursor.getColumnIndexOrThrow("$KEY_IMAGE"))
                    prodPrice = cursor.getFloat(cursor.getColumnIndexOrThrow("$KEY_PRICE"))
                    prodQTY = cursor.getInt(cursor.getColumnIndexOrThrow("$KEY_QTY"))
//                }catch (e: Exception){
//                    e.printStackTrace()
//                }


                val product = CartProduct(prodID, prodName, prodImage, prodPrice, prodQTY)
                cart.add(product)
            }while (cursor.moveToNext())
        }
        return cart
    }


    fun deleteProduct(product: CartProduct): Int{
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, product.Id)

        val success = db.delete(TABLE_NAME,"id = " + product.Id, null)
        db.close()
        return success
    }

    fun emptyCart(){
        val selectQuery = "DELETE FROM $TABLE_NAME"
        val db = writableDatabase

        db.execSQL(selectQuery)
        db.close()
        Log.i("Cart", "Cart has been emptied")
    }


    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "dBay.db"
        private const val TABLE_NAME = "CartProduct"
        private const val KEY_ID = "id"
        private const val KEY_IMAGE = "image"
        private const val KEY_NAME = "name"
        private const val KEY_PRICE = "price"
        private const val KEY_QTY = "qty"
    }
}