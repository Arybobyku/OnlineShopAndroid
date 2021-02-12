package com.example.onlineshop.Helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.onlineshop.model.UserModel
import com.google.gson.Gson

class SharedPref(activity:Activity) {
    val mypref="MAIN_PRF"
    val sp:SharedPreferences
    val login="login"

    val user:String = "USER"
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

    fun setUser(value:UserModel){
        val data:String = Gson().toJson(value,UserModel::class.java)
        sp.edit().putString(user,data).apply()
    }
    fun getUser():UserModel?{
        val data:String = sp.getString(user,null)?: return  null
        val json =Gson().fromJson<UserModel>(data,UserModel::class.java)
        return  json
    }
    fun setString(key:String,value:String){
     sp.edit().putString(key,value).apply()
    }
    fun getString(key:String):String{
        return sp.getString(key,"")!!
    }
}