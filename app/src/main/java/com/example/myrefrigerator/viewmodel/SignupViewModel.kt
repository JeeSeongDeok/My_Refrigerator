package com.example.myrefrigerator.views

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myrefrigerator.data.UserProfile
import com.example.myrefrigerator.model.RetrofitBuilder
import com.example.myrefrigerator.data.signupResult

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
    fun sendSignUpInfo(id: String, pass:String, name:String, phone:String, birth:String, gender:Int){
        // 연결하는 부분 OkHttp3 써서 백엔드랑 연결
        Log.d(TAG, "SingupViewModel - Call OkHttp3")
        // Post할 데이터들
        val data = UserProfile(id, pass, name, phone, "birth")
        Log.d(TAG, "SingupViewModel - id:" + id)


        val call = RetrofitBuilder.CONNET_SERVICE


        call.signUp(data).enqueue(object: Callback<signupResult>{
            override fun onFailure(call: Call<signupResult>, t: Throwable) {
                // 연결 실패한 경우
                Log.e(TAG, "실패 에러: ${t.message}" )
            }

            override fun onResponse(call: Call<signupResult>, response: Response<signupResult>) {
                // 연결 성공한 경우
                Log.e(TAG, response.body().toString() +"와 성공")
            }

        })

    }
}