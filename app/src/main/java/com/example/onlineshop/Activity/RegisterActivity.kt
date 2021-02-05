package com.example.onlineshop.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.Helper.SharedPref
import com.example.onlineshop.MainActivity
import com.example.onlineshop.R
import com.example.onlineshop.app.ApiConfig
import com.example.onlineshop.model.ResponseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity: AppCompatActivity()  {
    lateinit var btn_register: Button
    lateinit var fullname: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var phone: EditText
    lateinit var sp:SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullname = findViewById(R.id.Et_FullnameRegis)
        email = findViewById(R.id.Et_EmailRegis)
        phone = findViewById(R.id.Et_PhoneRegis)
        password = findViewById(R.id.Et_PasswordRegis)
        sp = SharedPref(this)
        btn_register=findViewById(R.id.btn_Register)
        btn_register.setOnClickListener(View.OnClickListener {
            register()
        })
    }

    fun register(){
        if(fullname.text.isEmpty()){
            fullname.error="Nama Tidak Boleh Kosong"
            fullname.requestFocus()
            return
        }else if(email.text.isEmpty()){
            email.error="Email Tidak Boleh Kosong"
            email.requestFocus()
            return
        }else if(phone.text.isEmpty()){
            phone.error="phone Tidak Boleh Kosong"
            phone.requestFocus()
            return
        }else if(password.text.isEmpty()){
            password.error="password Tidak Boleh Kosong"
            password.requestFocus()
            return
        }
        val pb_registrasi:ProgressBar = findViewById(R.id.Pb_registrasi)

        pb_registrasi.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(fullname.text.toString(),email.text.toString(),password.text.toString()).enqueue(object :Callback<ResponseModel>{
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@RegisterActivity,"Error: "+t,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val respon = response.body()!!
                if(respon.success==1){
                    pb_registrasi.visibility = View.GONE
                    sp.statusLogin(true)
                    Toast.makeText(this@RegisterActivity,"Selamat Datang: "+respon.user.name,Toast.LENGTH_SHORT).show()
                    val move:Intent = Intent(this@RegisterActivity,MainActivity::class.java)
                    move.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(move)
                    finish()
                }else{
                    pb_registrasi.visibility = View.GONE
                    Toast.makeText(this@RegisterActivity,"Error: "+respon.message,Toast.LENGTH_SHORT).show()
                }
            }

        })

    }
}