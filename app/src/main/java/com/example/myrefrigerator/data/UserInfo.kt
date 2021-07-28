package com.example.myrefrigerator.data

data class UserInfo(
    var id: String? = null,
    var food1: String? = null,
    var foodshelflife1: String? = null,
    var food2: String? = null,
    var foodshelflife2: String? = null,
    var food3: String? = null,
    var foodshelflife3: String? = null,
    var food4: String? = null,
    var foodshelflife4: String? = null
)

data class UserProfile(
    var id: String? = null,
    var pw: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var date: String? = null,
)

data class loginResult(
    var result: String? = null
)

data class signupResult(
    var result: String? = null
)

