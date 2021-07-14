package com.example.myrefrigerator.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
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
    }


}