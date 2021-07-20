package com.example.myrefrigerator.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import org.koin.*


// 싱글톤
object RetrofitBuilder {
    // Retrofit을 사용하기 위한 함수
    // Base_url에 서버의 url를 넣으면 사용 가능하다
    private val retrofitClient: Retrofit.Builder by lazy{
        Retrofit.Builder()
            .baseUrl("BASE_URL")
            .addConverterFactory(GsonConverterFactory.create())
    }
    // API서버와 연결 시 Retrofit객체를 구현할 인터페이스를 통해 만든다.
    val ConnetService: ExampleInterface by lazy{
        retrofitClient.build().create(ExampleInterface::class.java)
    }

}