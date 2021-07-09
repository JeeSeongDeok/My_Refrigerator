package com.example.myrefrigerator.views

import androidx.lifecycle.ViewModel
import com.example.myrefrigerator.base.BaseViewModel

interface DataModel {
    fun getData()
}

class DataModelImpl: DataModel{
    override fun getData() {
        return
    }
}
class SignupViewModel(private val model:DataModel) : BaseViewModel() {
    private val TAG = "SignUpViewModel"

    fun sendSignUpInfo(query: String, age:Int){
        // 연결하는 부분 OkHttp3 써서 백엔드랑 연결
    }
}