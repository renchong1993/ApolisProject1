package com.example.dbayproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.dbayproject.databinding.ActivityMainBinding
import com.example.dbayproject.login.ui.LoginActivity
import com.example.dbayproject.mainCategory.model.CatData
import com.example.dbayproject.mainCategory.ui.CategoryFragment
import com.example.dbayproject.product.ui.ProductsFragment
import com.example.dbayproject.shoppingcart.ui.CartFragment
import com.example.dbayproject.subCategory.model.SubCatData
import com.example.dbayproject.subCategory.ui.SubCatFragment

class MainActivity : AppCompatActivity(), Communicator {

    lateinit var binding: ActivityMainBinding
    lateinit var actionBarToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Fragment of all Categories
        addFragment(CategoryFragment())


        val sharedPreferences = getSharedPreferences("LoginSP", Context.MODE_PRIVATE)

//        binding.uservalue.text =
//            "Welcome to home " + sharedPreferences.getString("firstName", "Default")
        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarToggle)

        actionBarToggle.isDrawerIndicatorEnabled = false
        binding.toolbar.setNavigationIcon(R.drawable.ic_menu)
        binding.toolbar.setNavigationOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        actionBarToggle.syncState()

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isCheckable = true
            binding.drawerLayout.closeDrawers()

            when (menuItem.itemId) {
                R.id.shoppingcart -> {
//                    startActivity(Intent(this, CartActivity::class.java))
                }
                R.id.profile -> {
//                    startActivity(Intent(this, ProfileActivity::class.java))
                }
                R.id.shop -> {
                    Toast.makeText(this, "I am SHOP", Toast.LENGTH_SHORT).show()
                }
                R.id.orderhistory -> {
                    Toast.makeText(this, "I am OrderHistory", Toast.LENGTH_SHORT).show()
                }
                R.id.logout -> {
                        logout()
                }
            }
            true
        }

        binding.buttonCart.setOnClickListener {
            val cartFragment = CartFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()

            transaction.replace(R.id.container, cartFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.textviewDbayTitle.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shoppingcart -> {
//                    startActivity(Intent(this, CartActivity::class.java))
                return true
            }
            R.id.profile -> {
//                    startActivity(Intent(this, ProfileActivity::class.java))
                return true
            }
            R.id.shop -> {
                Toast.makeText(this, "I am SHOP", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.orderhistory -> {
                Toast.makeText(this, "I am OrderHistory", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.logout -> {
                Toast.makeText(this, "I am Logout", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return false
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navView)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun logout() {

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            "LoginSP",
            Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("is_loggerIn", false)
        editor.apply()

        startActivity(Intent(baseContext, LoginActivity::class.java))
        Toast.makeText(baseContext, "Log out successfully", Toast.LENGTH_SHORT).show()
    }


    fun AppCompatActivity.addFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    fun AppCompatActivity.replaceFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun toSubCat(catData: CatData) {
        val bundle = Bundle()
        val imgUrl = "https://rjtmobile.com/grocery/images/"+catData.catImage

        bundle.putInt("categoryID", catData.catId)
        bundle.putString("categoryName", catData.catName)
        bundle.putString("categoryImg", imgUrl)

        val subCatFragment = SubCatFragment()
        subCatFragment.arguments = bundle
//        binding.root.removeAllViews()
//
//        supportFragmentManager.beginTransaction().replace(R.id.container, subCatFragment).commit()


        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, subCatFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun toProd(subCatData: SubCatData) {
        val bundle = Bundle()
        val imgUrl = "https://rjtmobile.com/grocery/images/"+subCatData.subImage

        bundle.putInt("subCategoryID", subCatData.subId)
        bundle.putString("subCategoryName", subCatData.subName)
        bundle.putString("subCategoryImg", imgUrl)

        val productsFragment = ProductsFragment()
        productsFragment.arguments = bundle


        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, productsFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}