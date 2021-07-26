package com.example.myrefrigerator.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myrefrigerator.data.UserInfo
import com.example.myrefrigerator.model.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        var check = false;

        val call = RetrofitBuilder.CONNET_SERVICE


        call.getUser().enqueue(object: Callback<UserInfo>{
            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.e(TAG, "실패 에러: ${t.message}" )
            }

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                Log.e(TAG, response.body().toString() +"와 성공")
            }

        })
    }
}