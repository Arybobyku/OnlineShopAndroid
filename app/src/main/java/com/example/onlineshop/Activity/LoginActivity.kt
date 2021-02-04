package com.example.onlineshop.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.onlineshop.Helper.SharedPref
import com.example.onlineshop.R

class LoginActivity : AppCompatActivity() {
    private lateinit var sp:SharedPref
    lateinit var btn_SignIn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sp=SharedPref(this)
        btn_SignIn = findViewById(R.id.Btn_SignIn)
        btn_SignIn.setOnClickListener(View.OnClickListener {
            sp.statusLogin(true)
        })
    }
}