package com.example.myrefrigerator.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


data class Student(
    // studentId는 student_id를 받을 수 없기 때문에 SerializedName으로 value값을 알려줌
    @SerializedName("student_id")
    val studentId: Int,
    val name: String,
    val phone: String
)

data class exampleResponse(
    // API 서버에서 받을 때 student라는 데이터가 하나가 아니라 여러개이기 때문에 list를 통해 받음
    val student: List<Student>? = null
)

/*
이런 데이터를 받을 것임
{
	"student" : [
		{
			"student_id": 30410,
			"name" : "홍길동",
			"phone" : "010-12345-1234"
		},
		{
			"student_id": 30411,
			"name" : "고길동",
			"phone" : "010-53455-1256"
		},
		{
			"student_id": 30413,
			"name" : "둘리",
			"phone" : "010-35243-5345"
		},
		{
			"student_id": 30414,
			"name" : "아이유",
			"phone" : "010-13352-5343"
		}
	]
}



 */