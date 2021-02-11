package com.example.onlineshop.Helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref(activity:Activity) {
    val mypref="MAIN_PRF"
    val sp:SharedPreferences
    val login="login"

    val nama:String = "nama"
    val email:String = "email"
    init {
        sp=activity.getSharedPreferences(mypref,Context.MODE_PRIVATE)
    }
    fun statusLogin(status:Boolean){
        sp.edit().putBoolean(login,status).apply()
    }
    fun getStatusLogin():Boolean{
        return sp.getBoolean(login,false)
    }

    fun setString(key:String,value:String){
     sp.edit().putString(key,value).apply()
    }
    fun getString(key:String):String{
        return sp.getString(key,"")!!
    }
}