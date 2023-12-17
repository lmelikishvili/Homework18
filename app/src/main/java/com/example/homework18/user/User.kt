package com.example.homework18.user

import com.squareup.moshi.Json

data class User(
    @Json(name = "id")
    var id: Int,
    @Json(name = "email")
    var email: String,
    @Json(name = "first_name")
    var firsName: String,
    @Json(name = "last_name")
    var lastName: String,
    @Json(name = "avatar")
    var avatar: String
)

