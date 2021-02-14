package com.example.onlineshop.Helper

import java.text.NumberFormat
import java.util.*

class funHelper {
    fun FormatUang(jumlah:String):String{
        var string:String =NumberFormat.getCurrencyInstance(Locale("in","ID")).format(Integer.valueOf(jumlah))
       return  string
    }
}