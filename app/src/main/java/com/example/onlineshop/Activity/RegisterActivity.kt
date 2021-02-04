package com.example.onlineshop.Activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.R
import com.example.onlineshop.app.ApiConfig
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullname = findViewById(R.id.Et_FullnameRegis)
        email = findViewById(R.id.Et_EmailRegis)
        phone = findViewById(R.id.Et_PhoneRegis)
        password = findViewById(R.id.Et_PasswordRegis)

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

        ApiConfig.instanceRetrofit.register(email.text.toString(),fullname.text.toString(),password.text.toString()).enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
              //handel ketika gagal
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
              //handel ketika sukses
            }

        })

    }
}