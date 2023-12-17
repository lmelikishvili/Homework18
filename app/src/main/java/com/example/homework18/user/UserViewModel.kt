package com.example.homework18.user

import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
//    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//    fun getUsers(url: String) {
//        var users = mutableListOf<User>()
//
//        val api = Retrofit.Builder()
//            .baseUrl(url)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//            .create(Api::class.java)
//
//        api.getUsers().enqueue(object : Callback<People> {
//            override fun onResponse(call: Call<People>, response: Response<People>) {
//                //d("usersBody", "${response.body()?.data?.get(1)}")
//                for (user in response.body()?.data!!) {
//                    users.add(User(user.id, user.first_name, user.last_name, user.email, user.avatar))
//                    d("usersBody", "${user.email}")
//                }
//                d("ListOfUsers", "${users.toString()}")
//            }
//            override fun onFailure(call: Call<People>, t: Throwable) {
//                d("FailedTask", "${t.message}")
//            }
//        })
//    }
}