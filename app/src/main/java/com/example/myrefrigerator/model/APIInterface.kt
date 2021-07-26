package com.example.myrefrigerator.model

import com.example.myrefrigerator.data.UserInfo
import com.example.myrefrigerator.data.UserProfile
import com.example.myrefrigerator.data.signupResult
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("user")
    @Headers("accept: application/json", "content-type: application/json")
    fun getUser(): Call<UserInfo>
    @Headers("accept: application/json", "content-type: application/json")
    @POST("signup")
    fun signUp(
        @Body userprofile: UserProfile
    ) : Call<signupResult>

}