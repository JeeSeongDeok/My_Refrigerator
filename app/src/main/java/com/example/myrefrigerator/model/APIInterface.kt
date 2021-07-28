package com.example.myrefrigerator.model

import com.example.myrefrigerator.data.UserInfo
import com.example.myrefrigerator.data.UserProfile
import com.example.myrefrigerator.data.loginResult
import com.example.myrefrigerator.data.signupResult
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("user")
    @Headers("accept: application/json", "content-type: application/json")
    fun login(
        @Query("id")id: String,
        @Query("pw")pw: String
    ): Call<loginResult>
    @Headers("accept: application/json", "content-type: application/json")
    @POST("signup")
    fun signUp(
        @Body userprofile: UserProfile
    ) : Call<signupResult>
    @Headers("accept: application/json", "content-type: application/json")
    @GET("food")
    fun getFood(
        @Query("id")id: String
    ): Call<UserInfo>
}