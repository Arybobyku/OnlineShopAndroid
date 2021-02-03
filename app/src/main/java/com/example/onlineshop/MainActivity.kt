package com.example.onlineshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.onlineshop.Fragment.AkunFragment
import com.example.onlineshop.Fragment.HomeFragment
import com.example.onlineshop.Fragment.KeranjangFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val homefragment = HomeFragment();
    val keranjangFragment = KeranjangFragment();
    val akunFragment = AkunFragment();

    private val  fm:FragmentManager=supportFragmentManager
    private var active:Fragment = homefragment
    private lateinit var menu:Menu
    private lateinit var menuItem:MenuItem
    private lateinit var navBottom:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomNav()
    }
    fun setBottomNav(){
        navBottom = findViewById(R.id.nav_view)
        menu = navBottom.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked=true

        fm.beginTransaction().add(R.id.nav_host_fragment,homefragment).show(homefragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment,keranjangFragment).hide(keranjangFragment).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment,akunFragment).hide(akunFragment).commit()

        navBottom.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.navigation_home->{
                    CurrentFragment(homefragment,0)
                }
                R.id.navigation_Keranjang->{
                    CurrentFragment(keranjangFragment,1)
                }
                R.id.navigation_Akun->{
                    CurrentFragment(akunFragment,2)
                }
            }

            false
        }
    }

    fun CurrentFragment(fragment:Fragment,pos:Int){
        menuItem=menu.getItem(pos)
        menuItem.isChecked=true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active=fragment

    }
}