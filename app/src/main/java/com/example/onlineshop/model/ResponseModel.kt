package com.example.onlineshop.model

class ResponseModel {
    var success =0
    lateinit var message:String
    var user = UserModel()
    var produks:ArrayList<ProdukModel> = ArrayList()
}