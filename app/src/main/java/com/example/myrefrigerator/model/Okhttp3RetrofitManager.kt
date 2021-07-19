package com.example.myrefrigerator.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Okhttp3RetrofitManager {
    private val TIMEOUT = 30L
    private val HOSTURL =  "https://jsonplaceholder.typicode.com/"//HOST URL
    private var retrofit : Retrofit
    private var okHttpClient : OkHttpClient
    private var gson : Gson
    init{
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        gson = GsonBuilder().setLenient().create()
        okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(HOSTURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
    internal fun <T> getRetrofitService(retClass : Class<T>) : T{
        return retrofit.create(retClass)
    }
}