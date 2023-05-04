package com.example.chatting.userlist

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.chatting.databinding.ItemUserBinding

class UserAdapter: ListAdapter<UserItem, UserAdapter.ViewHolder>(differ) {

    inner class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

    }



    companion object{
        val differ = object : DiffUtil.ItemCallback<UserItem>(){
            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem.UserId == newItem.UserId
            }

            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}