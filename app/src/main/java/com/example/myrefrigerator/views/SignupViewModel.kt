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
    fun connectServer(id: String, pw:String){
        // API에 서버 연결
        // 대충 연결 후
        // 넘기자!
    }
}