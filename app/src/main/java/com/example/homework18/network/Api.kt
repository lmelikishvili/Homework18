package com.example.homework18.network

import com.example.homework18.user.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("users?page=1")
    fun getUsers(): Call<List<User>>
}