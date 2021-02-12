package com.example.onlineshop.Fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.onlineshop.Activity.LoginActivity
import com.example.onlineshop.Helper.SharedPref
import com.example.onlineshop.R

class AkunFragment :Fragment(){
    private lateinit var sp:SharedPref
    lateinit var btn_LogOut:Button
    lateinit var name:TextView
    lateinit var  email:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_akun, container, false)

        sp= SharedPref(requireActivity())
        init(view)
        setData()
        mainButton(view)
        return view
    }
    fun setData(){

        if(sp.getUser() == null){
            val move = Intent(activity,LoginActivity::class.java)
            move.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(move)
        }else{
            val user = sp.getUser()!!
            name.text =user.name
            email.text =user.email
        }



    }
    fun mainButton(view:View){
        //Button Keluar
        btn_LogOut = view.findViewById(R.id.Btn_LogOut)
        btn_LogOut.setOnClickListener(View.OnClickListener {
            sp.statusLogin(false)
           val move = Intent(activity,LoginActivity::class.java)
            move.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(move)
            activity?.finish()
        })

    }

    private fun init(view:View){
        name = view.findViewById(R.id.Tv_Name_Akun)
        email = view.findViewById(R.id.Tv_Email_Akun)

    }

}