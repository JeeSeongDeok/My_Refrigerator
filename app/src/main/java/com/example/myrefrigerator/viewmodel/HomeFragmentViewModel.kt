package com.example.myrefrigerator.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrigerator.data.UserInfo
import com.example.myrefrigerator.model.RetrofitBuilder
import javax.security.auth.callback.Callback

class HomeFragmentViewModel: ViewModel() {
    companion object {
        const val TAG: String = "로그"
    }
    // 변경 가는한 Live Data
    private val _resultLiveData = MutableLiveData<Boolean>()
    val resultLiveData: LiveData<Boolean>
        get() = _resultLiveData
    // init 초기값 설정
    init{
        Log.d(TAG, "LoginViewModel - called()")
        _resultLiveData.value = false;
    }

    fun connect(id: String){
        val call = RetrofitBuilder.CONNET_SERVICE

        // call something
    }
}