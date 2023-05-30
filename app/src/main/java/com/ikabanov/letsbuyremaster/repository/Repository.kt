package com.ikabanov.letsbuyremaster.repository

import com.ikabanov.letsbuyremaster.data.ProductModel
import com.ikabanov.letsbuyremaster.utils.Response

interface Repository {
    fun create(newProduct: ProductModel): Response
    fun update(oldProduct: ProductModel, newProduct: ProductModel): Response
    fun delete(deletedProduct: ProductModel): Response
    fun list(): List<ProductModel>
    fun getProduct(findProduct: ProductModel): ProductModel?
}