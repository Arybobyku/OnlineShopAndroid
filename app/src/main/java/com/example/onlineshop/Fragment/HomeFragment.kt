package com.example.onlineshop.Fragment

import android.os.Bundle
import android.transition.Slide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.onlineshop.Adapter.ProdukEletronikAdapter
import com.example.onlineshop.Adapter.ProdukLaptopAdapter
import com.example.onlineshop.Adapter.ProdukTerlarisAdapter
import com.example.onlineshop.Adapter.SlidePhotoAdapter
import com.example.onlineshop.R
import com.example.onlineshop.model.ProduckEletronikModel

class HomeFragment:Fragment() {

    lateinit var vp:ViewPager
    lateinit var RvProdukElektro:RecyclerView
    lateinit var RvProdukTeralris:RecyclerView
    lateinit var RvProdukLaptop:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View =  inflater.inflate(R.layout.fragment_home, container, false)
        slider(view)
        rvElectronik(view)
        rvTerlaris(view)
        rvLaptop(view)
        return  view
    }

    fun slider(view:View){
        vp=view.findViewById(R.id.vp_slider)

        val photoslide = ArrayList<Int>()
        photoslide.add(R.drawable.s1)
        photoslide.add(R.drawable.s2)
        photoslide.add(R.drawable.s3)

        val adapterslide = SlidePhotoAdapter(photoslide,activity)
        vp.adapter = adapterslide
    }
    fun rvElectronik(view:View){
        RvProdukElektro=view.findViewById(R.id.Rv_ProdukEletronik)
        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        RvProdukElektro.adapter=ProdukEletronikAdapter(arrproduk)
        RvProdukElektro.layoutManager=layoutmanager
    }
    fun rvTerlaris(view:View){
        RvProdukTeralris=view.findViewById(R.id.Rv_ProdukTerlaris)
        val layoutmanager1 = LinearLayoutManager(activity)
        layoutmanager1.orientation = LinearLayoutManager.HORIZONTAL
        RvProdukTeralris.adapter=ProdukTerlarisAdapter(arrproduk)
        RvProdukTeralris.layoutManager=layoutmanager1
    }
    fun rvLaptop(view:View){
        RvProdukLaptop=view.findViewById(R.id.Rv_ProdukLaptop)
        val layoutmanager2 = LinearLayoutManager(activity)
        layoutmanager2.orientation = LinearLayoutManager.HORIZONTAL
        RvProdukLaptop.adapter=ProdukLaptopAdapter(arrproduk1)
        RvProdukLaptop.layoutManager=layoutmanager2
    }
    val arrproduk:ArrayList<ProduckEletronikModel>get() {
        val arr=ArrayList<ProduckEletronikModel>()
        val p1 = ProduckEletronikModel()
        p1.name="Laptop Mackbook Pro 2021"
        p1.harga="Rp.31.000.000"
        p1.gambar=R.drawable.rv1

        val p2 = ProduckEletronikModel()
        p2.name="Laptop Asus ROG"
        p2.harga="Rp.18.000.000"
        p2.gambar=R.drawable.rv2

        val p3 = ProduckEletronikModel()
        p3.name="Laptop Xp Envy"
        p3.harga="Rp.15.000.000"
        p3.gambar=R.drawable.rv3
        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        return  arr
    }
    val arrproduk1:ArrayList<ProduckEletronikModel>get() {
        val arr=ArrayList<ProduckEletronikModel>()
        val p1 = ProduckEletronikModel()
        p1.name="Laptop Tuf Gamming"
        p1.harga="Rp.11.000.000"
        p1.gambar=R.drawable.rv3


        val p2 = ProduckEletronikModel()
        p2.name="Laptop AlienWare"
        p2.harga="Rp.18.000.000"
        p2.gambar=R.drawable.rv1

        val p3 = ProduckEletronikModel()
        p3.name="Laptop Msi Limmites"
        p3.harga="Rp.15.000.000"
        p3.gambar=R.drawable.rv2

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        return  arr
    }
}