package com.example.myrefrigerator.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    companion object {
        const val TAG: String = "로그"
    }
    // init 초기값 설정
    init{
        Log.d(TAG, "LoginViewModel - called()")
    }
    fun Login(id:String, pw:String){
        // 연결하는 부분 OkHttp3 써서 백엔드랑 연결
        Log.d(TAG, "SingupViewModel - Login Call")

    }
}