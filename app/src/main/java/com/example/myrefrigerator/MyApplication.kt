package com.example.myrefrigerator

import android.app.Application
import org.koin.standalone.StandAloneContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}