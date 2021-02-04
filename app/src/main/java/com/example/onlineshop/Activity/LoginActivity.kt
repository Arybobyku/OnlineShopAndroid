package com.example.onlineshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.onlineshop.Helper.SharedPref
import com.example.onlineshop.R

class LoginActivity : AppCompatActivity() {
    private lateinit var sp:SharedPref
    lateinit var btn_SignIn:Button
    lateinit var btn_SignUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sp=SharedPref(this)
        MainButton()
    }
    fun MainButton(){

        //button login
        btn_SignIn = findViewById(R.id.Btn_SignIn)
        btn_SignIn.setOnClickListener {
            sp.statusLogin(true)
        }
        //button daftar
        btn_SignUp = findViewById(R.id.Btn_SignUp)
        btn_SignUp.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }
}