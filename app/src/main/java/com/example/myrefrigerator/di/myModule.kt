package com.example.myrefrigerator.di

import com.example.myrefrigerator.views.DataModel
import com.example.myrefrigerator.views.DataModelImpl
import com.example.myrefrigerator.views.SignupViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/*
* 의존성 주입을 위한 모듈들
 */

var modelPart = module {
    factory<DataModel> {
        DataModelImpl()
    }
}

var viewModelPart = module {
    viewModel {
        SignupViewModel(get())
    }
}

var myDiModule = listOf(modelPart, viewModelPart)