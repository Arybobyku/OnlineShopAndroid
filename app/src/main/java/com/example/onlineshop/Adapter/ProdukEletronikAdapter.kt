package com.example.onlineshop.Adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.model.ProduckEletronikModel
import com.example.onlineshop.model.ProdukModel
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ProdukEletronikAdapter(var arrProduk:ArrayList<ProdukModel>): RecyclerView.Adapter<ProdukEletronikAdapter.ViewHolder>() {

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tvnama = view.findViewById<TextView>(R.id.tv_RvProdukName)
        val tvprice = view.findViewById<TextView>(R.id.tv_RvProdukPrice)
        val image = view.findViewById<ImageView>(R.id.iv_RvProdukImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view:View= LayoutInflater.from(parent.context).inflate(R.layout.item_produk_elektronik,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrProduk.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvnama.text = arrProduk[position].name
        holder.tvprice.text = arrProduk[position].harga
        holder.tvprice.text = NumberFormat.getCurrencyInstance(Locale("in","ID")).format(Integer.valueOf(arrProduk[position].harga))
        val image ="http://192.168.100.10/OnlineShopLaravel/public/storage/produk/"+arrProduk[position].image
        Picasso.get().load(image).placeholder(R.drawable.profile).error(R.drawable.profile).into(holder.image)
    }

}