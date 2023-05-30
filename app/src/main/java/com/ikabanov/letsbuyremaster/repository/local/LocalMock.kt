package com.ikabanov.letsbuyremaster.repository.local

import com.ikabanov.letsbuyremaster.data.ProductModel
import com.ikabanov.letsbuyremaster.repository.Repository
import com.ikabanov.letsbuyremaster.utils.Response

object LocalMock : Repository {
    private val products = mutableListOf<ProductModel>()

    override fun create(newProduct: ProductModel): Response {
        products.add(newProduct)
        return Response.SUCCESSFUL
    }

    override fun update(oldProduct: ProductModel, newProduct: ProductModel): Response {
        val index = products.indexOf(oldProduct)
        if (index != -1) {
            products[index] = newProduct
            return Response.SUCCESSFUL
        }
        return Response.FAILURE
    }

    override fun delete(deletedProduct: ProductModel): Response {
        val index = products.indexOf(deletedProduct)
        if (index != -1) {
            products.removeAt(index)
            return Response.SUCCESSFUL
        }
        return Response.FAILURE
    }

    override fun list(): List<ProductModel> {
        if (products.isEmpty()) {
            initList()
        }

        return products
    }

    override fun getProduct(findProduct: ProductModel): ProductModel? {
        val index = products.indexOf(findProduct)
        if (index != -1) {
            return products[index]
        }
        return null
    }

    private fun initList() {
        products.add(ProductModel(0, "apple"))
        products.add(ProductModel(1, "orange"))
        products.add(ProductModel(2, "banana"))
        products.add(ProductModel(3, "melon"))
        products.add(ProductModel(4, "lime"))
        products.add(ProductModel(5, "grape"))
        products.add(ProductModel(6, "carrot"))
        products.add(ProductModel(7, "potato"))
        products.add(ProductModel(8, "onion"))
        products.add(ProductModel(9, "cucumber"))
        products.add(ProductModel(10, "fish"))
        products.add(ProductModel(11, "meat"))
        products.add(ProductModel(12, "bread"))
        products.add(ProductModel(13, "berries"))
        products.add(ProductModel(14, "cabbage"))
        products.add(ProductModel(15, "watermelon"))
        products.add(ProductModel(16, "chocolate"))
    }
}