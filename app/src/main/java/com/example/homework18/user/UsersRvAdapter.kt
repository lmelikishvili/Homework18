package com.example.homework18.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework18.databinding.UserItemBinding

class UsersRvAdapter: ListAdapter<User, UsersRvAdapter.UserVH>(UsetDiffUtil()) {

    class UsetDiffUtil: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH = UserVH(UserItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind()
    }


    inner class UserVH(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var user: User
        fun bind(){
            user = currentList[adapterPosition]
            with(binding){
                tvID.text = "ID ${user.id}"
                tvName.text = "Name: ${user.firsName} ${user.email}"
                tvEmail.text = "Email: ${user.lastName}"
            }
        }
    }
}