package com.example.homework18.network

import com.example.homework18.user.People
import retrofit2.http.GET

interface Api {
    @GET("users?page=1")
    suspend fun getUsers(): retrofit2.Response<People>
}