package com.example.myrefrigerator

import android.app.Application
import com.example.myrefrigerator.di.myDiModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.StandAloneContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}