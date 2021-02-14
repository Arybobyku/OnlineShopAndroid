package com.example.onlineshop.model

import java.io.Serializable

class ProdukModel: Serializable {
    lateinit var name:String
    lateinit var harga:String
    lateinit var image:String
    lateinit var deskripsi:String
    lateinit var id:String
    lateinit var created_at:String
    lateinit var updated_at:String
    var category_id = 0
}