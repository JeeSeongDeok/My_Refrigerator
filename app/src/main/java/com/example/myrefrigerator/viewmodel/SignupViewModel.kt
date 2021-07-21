package com.example.myrefrigerator.views

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myrefrigerator.model.RetrofitBuilder
import com.example.myrefrigerator.model.UserInfo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val call = RetrofitBuilder.ConnetService

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