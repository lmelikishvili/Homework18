package com.example.homework18.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework18.BaseFragment
import com.example.homework18.R
import com.example.homework18.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
    private val viewModel: UserViewModel by viewModels()
    private val BASE_URL = "https://reqres.in/api/"

    override fun setup() {


    }

    override fun setupListeners() {

    }

    override fun bindData() {

    }

}