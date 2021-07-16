package com.example.myrefrigerator.model

import okhttp3.Call
import retrofit2.http.GET

interface RetrofitInterface{
    @GET("todos/1/")
    fun getTodos() : Call<myData>
}

