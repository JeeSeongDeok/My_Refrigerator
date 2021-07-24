package com.example.myrefrigerator.views

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myrefrigerator.FRAGMENTS.HomeFragment
import com.example.myrefrigerator.FRAGMENTS.menuFragment
import com.example.myrefrigerator.FRAGMENTS.musicFragment
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val Home = HomeFragment()
    private val Music = musicFragment()
    companion object {
        const val TAG: String = "로그"
    }
    private lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 바인딩
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)

        val bottomNavigationView = findViewById<View>(R.id.myBottomNav) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when (item.itemId) {
                R.id.homeFragment->{
                    changeFragment(Home)
                }
                R.id.menuFragment -> {
                    val builder = AlertDialog.Builder(this)
                    val dialogView = layoutInflater.inflate(R.layout.dialog_addfood, null)
                    builder.setView(dialogView)
                        .setPositiveButton("확인") { dialogInterface, i ->
                            Log.d(MainActivity.TAG, "HomeFragment - Positive Call()")
                        }
                        .setNegativeButton("취소") { dialogInterface, i ->
                            /* 취소일 때 아무 액션이 없으므로 빈칸 */
                        }
                        .show()
                }
                R.id.musicFragment->{
                    changeFragment(Music)
                }
            }
            true
        }
    }

    private fun changeFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.my_nav_host, fragment)
            .commit()
    }
}



