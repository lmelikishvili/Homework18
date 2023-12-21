package com.example.homework18.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework18.utils.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class UserViewModel : ViewModel() {
    private val _userFlow = MutableStateFlow<List<User>>(emptyList())
    val userFlow: StateFlow<List<User>> = _userFlow

    fun getUsers() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getUsers()
            } catch (e: IOException) {
                return@launch
            } catch (e: retrofit2.HttpException) {
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                viewModelScope.launch {
                    _userFlow.value = userFlow.value.toMutableList().also {
                        for (user in response.body()!!.data) {
                            it.add(
                                User(
                                    id = user.id,
                                    firsName = user.first_name,
                                    lastName = user.last_name,
                                    email = user.email,
                                    avatar = user.avatar
                                )
                            )
                        }
                        //d("UsersList", "${users}")
                    }
                }
            }
        }
    }
}