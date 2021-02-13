package com.example.onlineshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.onlineshop.Helper.SharedPref
import com.example.onlineshop.MainActivity
import com.example.onlineshop.R
import com.example.onlineshop.app.ApiConfig
import com.example.onlineshop.model.ProdukModel
import com.example.onlineshop.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            checkUser()
        }
        //button daftar
        btn_SignUp = findViewById(R.id.Btn_SignUp)
        btn_SignUp.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }
    fun checkUser(){
        val email:EditText = findViewById(R.id.Et_EmailLogin)
        val password:EditText = findViewById(R.id.Et_PasswordLogin)

        if(email.text.isEmpty()){
            email.error="Masukan Email Anda!"
            email.requestFocus()
            return
        }else if(password.text.isEmpty()){
            password.error="Masukan Password Anda!"
            password.requestFocus()
            return
        }

        val pb_login:ProgressBar = findViewById(R.id.Pb_Login)
        pb_login.visibility = View.VISIBLE

        ApiConfig.instanceRetrofit.login(email.text.toString(),password.text.toString()).enqueue(object:Callback<ResponseModel>{
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity,"error"+t,Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val respon= response.body()!!
                if(respon.success==1){
                    pb_login.visibility = View.GONE
                    Toast.makeText(this@LoginActivity,respon.message,Toast.LENGTH_LONG).show()
                    sp.statusLogin(true)
                    //cara manual
//                    sp.setString(sp.nama,respon.user.name)
//                    sp.setString(sp.email,respon.user.email)
                    sp.setUser(respon.user)
                    val move:Intent= Intent(this@LoginActivity,MainActivity::class.java)
                    //menghapus acticity flag yg ada di cache
                    move.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(move)
                    finish()
                }else{
                    pb_login.visibility = View.GONE
                    Toast.makeText(this@LoginActivity,"Eror : "+respon.message,Toast.LENGTH_LONG).show()
                }
            }

        })
    }
}