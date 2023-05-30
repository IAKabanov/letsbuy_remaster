package com.ikabanov.letsbuyremaster.data

data class ProductModel(val id: Int) {
    var name: String = "WRONG NAME"

    constructor(id: Int, name: String) : this (id) {
        this.name = name
    }
}
