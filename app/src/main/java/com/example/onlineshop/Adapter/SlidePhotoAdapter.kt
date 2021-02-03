package com.example.onlineshop.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.onlineshop.R

class SlidePhotoAdapter(var data:ArrayList<Int>,var context:Activity?):PagerAdapter(){
    lateinit var layoutInflate:LayoutInflater
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
        }

    override fun getCount(): Int {
       return data.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflate= LayoutInflater.from(context)
        val view = layoutInflate.inflate(R.layout.item_slider,container,false)
        //init
        val imageview:ImageView
            imageview = view.findViewById(R.id.iv_slidePhoto)

        imageview.setImageResource(data[position])
        container.addView(view,0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}