package com.example.homework18.user

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework18.BaseFragment
import com.example.homework18.databinding.FragmentUserBinding
import kotlinx.coroutines.launch

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
    private val viewModel: UserViewModel by viewModels()
    private val adapter: UsersRvAdapter by lazy {
        UsersRvAdapter()
    }

    override fun setup() {
        viewModel.getUsers()
        with(binding) {
            usersRecyclerView.adapter = adapter
            usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun setupListeners() {

    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userFlow.collect {
                    adapter.submitList(it)
                }
            }
        }
    }
}