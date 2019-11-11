package com.e.apotik

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.webkit.WebView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    lateinit var navView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.nav_host_fragment, HomeFragment()).commit()
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
                R.id.navigation_Home -> {
                    fm = supportFragmentManager
                    ft = fm.beginTransaction()
                    ft.replace(R.id.nav_host_fragment, HomeFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_Obat -> {
                    fm = supportFragmentManager
                    ft = fm.beginTransaction()
                    ft.replace(R.id.nav_host_fragment, Obat()).commit()
                    return@OnNavigationItemSelectedListener true
                }
            R.id.navigation_Outlet -> {
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.replace(R.id.nav_host_fragment, Outlet()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Histori ->{
                var i : Intent
                i = Intent(this@MainActivity,transaksi_isi::class.java)
                startActivity(i)
                return@OnNavigationItemSelectedListener true

            }
            }
            false
        }

}