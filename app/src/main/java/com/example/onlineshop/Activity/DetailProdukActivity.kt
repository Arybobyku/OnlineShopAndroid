package com.example.onlineshop.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.example.onlineshop.Helper.funHelper
import com.example.onlineshop.R
import com.example.onlineshop.model.ProdukModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class DetailProdukActivity : AppCompatActivity() {
    lateinit var name:TextView
    lateinit var price:TextView
    lateinit var des:TextView
    lateinit var image:ImageView
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        init()
        getInfo()
    }

    fun getInfo(){
        val data = intent.getStringExtra("extra")
        val produk = Gson().fromJson<ProdukModel>(data,ProdukModel::class.java)

        name.text = produk.name
        price.text = funHelper().FormatUang(produk.harga)
        des.text = produk.deskripsi
        val img ="http://192.168.100.10/OnlineShopLaravel/public/storage/produk/"+produk.image
        Picasso.get().load(img).placeholder(R.drawable.profile)
            .resize(400,400)
            .error(R.drawable.profile)
            .into(image)

        //toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title =produk.name
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    fun init(){
        name = findViewById(R.id.NameDetail)
        price = findViewById(R.id.HargaDetail)
        des = findViewById(R.id.DesDetail)
        image = findViewById(R.id.ImageDetail)
        toolbar = findViewById(R.id.toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}