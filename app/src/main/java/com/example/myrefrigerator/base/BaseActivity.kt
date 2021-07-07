package com.example.myrefrigerator.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_main)
    }
    
}