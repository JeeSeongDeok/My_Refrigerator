package com.example.myrefrigerator.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrigerator.data.UserInfo
import com.example.myrefrigerator.data.loginResult
import com.example.myrefrigerator.model.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
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
    fun Login(id:String, pw:String){
        val call = RetrofitBuilder.CONNET_SERVICE
        call.login(id, pw).enqueue(object: Callback<loginResult>{
            // 연결 실패
            override fun onFailure(call: Call<loginResult>, t: Throwable) {
                _resultLiveData.value = false;
            }
            override fun onResponse(call: Call<loginResult>, response: Response<loginResult>) {
                var result = response.body()?.result
                _resultLiveData.value = result == "true"
            }

        })
    }
}