package com.example.myrefrigerator.model


/*
아래의 데이터가 오기 때문에 데이터 클래스는 이런 형식으로 만들엇다.
{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}
 */
data class myData(val userId : Int, val id : Int, val title : String, val completed : Boolean)

