package com.binay.android.githubusers.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binay.android.githubusers.R
import com.binay.android.githubusers.models.UserItem
import com.bumptech.glide.Glide

class UsersRecyclerViewAdapter : RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder>() {
    private var mUsers = ArrayList<UserItem>()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatarImage: ImageView = itemView.findViewById(R.id.avatar_iv)
        var userNameTextView: TextView = itemView.findViewById(R.id.user_name)
        fun bindItem(userItem: UserItem) {
            userNameTextView.text = userItem.name
            Glide.with(itemView.context).load(userItem.imageUrl).into(avatarImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        val viewHolder = UserViewHolder(itemView)
        itemView.setOnClickListener {
            onItemClick(viewHolder.adapterPosition, it)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = mUsers[position]
        holder.bindItem(item)
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    private fun onItemClick(position: Int, view: View) {
        Log.d("ItemClick", "$position clicked")
    }

    fun addItems(items: ArrayList<UserItem>) {
        mUsers.addAll(items)
        notifyDataSetChanged()
    }
}