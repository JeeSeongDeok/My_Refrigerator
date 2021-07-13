package com.example.myrefrigerator.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel() {
    companion object {
        const val TAG: String = "로그"
    }
    // init 초기값 설정
    init{
        Log.d(TAG, "SingupViewModel - called()")
    }
    fun sendSignUpInfo(query: String, age:Int){
        // 연결하는 부분 OkHttp3 써서 백엔드랑 연결
        Log.d(TAG, "SingupViewModel - Call OkHttp3")
    }
}