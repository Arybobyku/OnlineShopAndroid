package com.example.onlineshop.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.onlineshop.Adapter.ProdukEletronikAdapter
import com.example.onlineshop.Adapter.ProdukLaptopAdapter
import com.example.onlineshop.Adapter.ProdukTerlarisAdapter
import com.example.onlineshop.Adapter.SlidePhotoAdapter
import com.example.onlineshop.R
import com.example.onlineshop.app.ApiConfig
import com.example.onlineshop.model.ProdukModel
import com.example.onlineshop.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment:Fragment() {

    lateinit var vp:ViewPager
    lateinit var RvProdukElektro:RecyclerView
    lateinit var RvProdukTeralris:RecyclerView
    lateinit var RvProdukLaptop:RecyclerView

   private var listProduk:ArrayList<ProdukModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View =  inflater.inflate(R.layout.fragment_home, container, false)
        slider(view)
        init(view)
        getProduck()
        return  view
    }
    fun init(view: View){
        RvProdukElektro=view.findViewById(R.id.Rv_ProdukEletronik)
        RvProdukTeralris=view.findViewById(R.id.Rv_ProdukTerlaris)
        RvProdukLaptop=view.findViewById(R.id.Rv_ProdukLaptop)
    }
    fun displayProduk(){

        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        RvProdukElektro.adapter=ProdukEletronikAdapter(requireActivity(),listProduk)
        RvProdukElektro.layoutManager=layoutmanager

        val layoutmanager1 = LinearLayoutManager(activity)
        layoutmanager1.orientation = LinearLayoutManager.HORIZONTAL
        RvProdukTeralris.adapter=ProdukTerlarisAdapter(requireActivity(),listProduk)
        RvProdukTeralris.layoutManager=layoutmanager1

        val layoutmanager2 = LinearLayoutManager(activity)
        layoutmanager2.orientation = LinearLayoutManager.HORIZONTAL
        RvProdukLaptop.adapter=ProdukLaptopAdapter(requireActivity(),listProduk)
        RvProdukLaptop.layoutManager=layoutmanager2

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


    fun getProduck(){
        ApiConfig.instanceRetrofit.getProduk().enqueue(object:Callback<ResponseModel>{
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(activity,"Failed To Get Product",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                if(res.success==1){
                    listProduk = res.produks
                    displayProduk()
                }
            }

        })
    }

}