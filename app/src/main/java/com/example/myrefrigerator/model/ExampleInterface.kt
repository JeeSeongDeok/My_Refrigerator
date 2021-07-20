package com.example.myrefrigerator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExampleInterface {
    // url/student 라는 API 연결 시 School_id, grade, classroom을 옆의 변수로 지정
    // Student 데이터 클래스 참고
    @GET("student")
    fun getStudent(@Query("school_id") schoolId: Int,
                   @Query("grade") grade: Int,
                   @Query("classroom") classroom: Int): Call<exampleResponse>
}