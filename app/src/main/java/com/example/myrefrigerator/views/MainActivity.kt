package com.example.myrefrigerator.views

import android.app.AlertDialog

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText

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

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 바인딩
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)


        //bottomNavigationView의 id를 가져와서 클릭 리스너를 생성
        val bottomNavigationView = findViewById<View>(R.id.myBottomNav) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                //bottomNavigation의 첫번째 버튼 클릭시 homeFragment로 이동
                R.id.homeFragment -> {
                    changeFragment(Home)
                }
                //bottomNavigation의 두번째 버튼 클릭시 menuFragment가 아닌 dialog_addfood call
                R.id.menuFragment -> {
                    val builder = AlertDialog.Builder(this)
                    val dialogView = layoutInflater.inflate(R.layout.dialog_addfood, null)
                    builder.setView(dialogView)

                        //확인버튼 클릭 시, 이름와 유통기한을 AllShelfLife로 보냄
                        .setPositiveButton("확인") { dialogInterface, i ->
                            Log.d(MainActivity.TAG, "HomeFragment - Positive Call()")
                            //다이어로글에서 음식이름과 유통기한 editText를 가져온다.
                            var Editname = dialogView.findViewById<EditText>(R.id.dialog_foodName)
                            var EditshelfLife = dialogView.findViewById<EditText>(R.id.dialog_foodshelflife)
                            var name = Editname.text.toString()
                            var shelfLife = EditshelfLife.text.toString()
                            //AllShelfLife로 dialog의 음식이름과 유통기한을 보낸다
                            val intent = Intent(this, AllShelfLife::class.java)
                            intent.putExtra("name", name)
                            intent.putExtra("shelfLife", shelfLife)
                            startActivity(intent)
                        }
                        //취소 버튼
                        .setNegativeButton("취소") { dialogInterface, i ->
                            /* 취소일 때 아무 액션이 없으므로 빈칸 */
                            Log.d(MainActivity.TAG, "HomeFragment - Negative Call()")
                        }
                        .show()
                }
                //bottomNavigation의 세번째 버튼 클릭시 musicFragment로 이동
                R.id.musicFragment -> {
                    changeFragment(Music)
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.my_nav_host, fragment)
            .commit()
    }
}



