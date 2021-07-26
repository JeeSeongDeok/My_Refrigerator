package com.example.myrefrigerator.data

data class UserInfo(
    var id: String? = null,
    var pw: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var date: String? = null,
    var gender: Int? = null
)

data class UserProfile(
    var id: String? = null,
    var pw: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var date: String? = null,
)

data class signupResult(
    var result: String? = null
)

