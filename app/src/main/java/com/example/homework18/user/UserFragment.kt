package com.example.homework18.user

import android.util.Log.d
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework18.BaseFragment
import com.example.homework18.databinding.FragmentUserBinding
import com.example.homework18.utils.RetrofitInstance
import kotlinx.coroutines.launch
import java.io.IOException

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
    private val viewModel: UserViewModel by viewModels()
    private lateinit var users: MutableList<User>
    private val adapter: UsersRvAdapter by lazy {
        UsersRvAdapter()
    }

    override fun setup() {
        users = mutableListOf()
        getAllUsers()

    }

    override fun setupListeners() {

    }

    override fun bindData() {

    }

    private fun getAllUsers(){
        lifecycleScope.launch() {
            val response = try {
                RetrofitInstance.api.getUsers()
            }catch (e: IOException){
                return@launch
            }catch (e: retrofit2.HttpException){
                return@launch
            }
            if(response.isSuccessful && response.body() != null){
                for (user in response.body()!!.data){
                    users.add(User(user.id, user.first_name, user.last_name, user.email, user.avatar))
                }
                with(binding){
                    usersRecyclerView.adapter = adapter
                    usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                    adapter.submitList(users)
                }
                d("UsersList", "${users}")
            }
        }
    }

}