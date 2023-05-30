package com.ikabanov.letsbuyremaster.utils

import com.ikabanov.letsbuyremaster.data.ProductModel
import java.lang.StringBuilder

object Converter {
    fun convertListToText(list: List<ProductModel>): String {
        val sb = StringBuilder()
        for (item in list) {
            sb.append("${item.name}\n")
        }
        return sb.toString()
    }

    fun convertTextToList(text: String): List<ProductModel> {
        val lines = text.split("\n")
        val list = mutableListOf<ProductModel>()
        for ((i, line) in lines.withIndex()) {
            list.add(ProductModel(i, line))
        }
        return list
    }
}