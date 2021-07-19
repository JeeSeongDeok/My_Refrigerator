package com.example.myrefrigerator.model

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface{
    @GET("todos/1/")
    fun getTodos(@Path("user") userId : String,
    id : String) : Call<TodosItem>
}