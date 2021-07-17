package com.example.myrefrigerator.views

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.ActivityMainBinding
import com.example.myrefrigerator.databinding.ActivityTestBinding
import com.example.myrefrigerator.model.Okhttp3RetrofitManager
import com.example.myrefrigerator.model.Okhttp3RetrofitManager.getRetrofitService
import com.example.myrefrigerator.model.RetrofitInterface
import com.example.myrefrigerator.model.TodosItem
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

class testActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val retClient = getRetrofitService(RetrofitInterface::class.java)
        val retrofit = retClient.getTodos()
        retrofit.enqueue(object : Callback<TodosItem> {
            override fun onFailure(call: Call<TodosItem>, t: Throwable) {
                t.printStackTrace()
            }
            override fun onResponse(call: Call<TodosItem>, response: Response<TodosItem>) {
                if(response.body()!=null){
                    val userId = "userId : ${response.body()?.userId}"
                    val id = "id : ${response.body()?.id}"
                    val title = "title : ${response.body()?.title}"
                    val completed = "completed : ${response.body()?.completed}"
                    mBinding.tvTodoId.text = id
                    mBinding.tvTodoCompleted.text = title
                }
            }
        })
    }
}