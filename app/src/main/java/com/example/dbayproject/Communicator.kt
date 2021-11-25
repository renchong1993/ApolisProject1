package com.example.dbayproject

import com.example.dbayproject.mainCategory.model.CatData
import com.example.dbayproject.subCategory.model.SubCatData

interface Communicator {

    fun toSubCat(catData: CatData)

    fun toProd(subCatData: SubCatData)
}