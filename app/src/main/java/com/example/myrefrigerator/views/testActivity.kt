package com.example.myrefrigerator.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.databinding.ActivityTestBinding
import com.example.myrefrigerator.model.RetrofitBuilder
import com.example.myrefrigerator.model.ExampleInterface
import com.example.myrefrigerator.model.Student
import com.example.myrefrigerator.model.exampleResponse
import retrofit2.Call;
import retrofit2.Callback
import retrofit2.Response


class testActivity : AppCompatActivity() {
    val schoolId = 10102
    val grade = 2
    val classroom = 4

    private lateinit var mBinding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }
    fun callConnectTest(){
        // RetrofitBuilder를 준비함(http 연결까지 담당
        val call = RetrofitBuilder.ConnetService
        // getStudent를 불러 어떤 형식인지 부른 후 enqueue 실행
        // enqueue는 exampleResponse(데이터클래스에 정의된 List<Student>)안에 데이터를 넣음
        call.getStudent(schoolId, grade, classroom).enqueue(object : Callback<exampleResponse>{
            override fun onResponse(call: Call<exampleResponse>, response: Response<exampleResponse>
            ) {
                // response.isSuccessful()은 연결도 성공하고, 문법도 잘 실행한 경우 발생
                // http 응답코드는 200, 성공 했다는 뜻이다.
                if(response.isSuccessful()) {
                    // 성공 처리
                }
                // 연결은 성공했지만 문법이 틀린 경우
                // http 응답코드는 400, 연결만 성공하고 요청은 실패함.
                else {
                    // 실패 처리
                }
            }

            override fun onFailure(call: Call<exampleResponse>, t: Throwable) {
                // 연결 실패한 구간
                // http 응답코드는 500이며, 응답을 실패했다는 뜻이다.
            }

        })
    }
}