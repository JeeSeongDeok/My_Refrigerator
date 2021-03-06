package com.example.myrefrigerator.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 싱글톤
object RetrofitBuilder {
    // Retrofit을 사용하기 위한 함수
    // Base_url에 서버의 url를 넣으면 사용 가능하다
    val gson : Gson =   GsonBuilder().setLenient().create();
    private val retrofitClient: Retrofit.Builder by lazy{
        Retrofit.Builder()
            .baseUrl("http://192.168.25.41:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    // API서버와 연결 시 Retrofit객체를 구현할 인터페이스를 통해 만든다.
    val CONNET_SERVICE: APIInterface by lazy{
        retrofitClient.build().create(APIInterface::class.java)
    }

}