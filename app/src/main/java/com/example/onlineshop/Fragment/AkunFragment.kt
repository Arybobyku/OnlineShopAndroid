package com.example.onlineshop.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.onlineshop.Helper.SharedPref
import com.example.onlineshop.R

class AkunFragment :Fragment(){
    private lateinit var sp:SharedPref
    lateinit var btn_LogOut:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_akun, container, false)

        sp= SharedPref(requireActivity())
        mainButton(view)
        return view
    }

    fun mainButton(view:View){
        //Button Keluar
        btn_LogOut = view.findViewById(R.id.Btn_LogOut)
        btn_LogOut.setOnClickListener(View.OnClickListener {
            sp.statusLogin(false)
        })

    }

}