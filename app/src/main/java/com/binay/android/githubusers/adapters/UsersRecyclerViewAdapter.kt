package com.binay.android.githubusers.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binay.android.githubusers.R
import com.binay.android.githubusers.interfaces.RecyclerAdapterListener
import com.binay.android.githubusers.models.UserItem
import com.bumptech.glide.Glide

class UsersRecyclerViewAdapter(context : Context) : RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder>() {
    private var mUsers = ArrayList<UserItem>()
    private var mContext = context

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
        val bookmarkView : ImageView = itemView.findViewById(R.id.bookmark)
        bookmarkView.setOnClickListener{
            onItemClick(viewHolder.adapterPosition, it as ImageView)
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

    private fun onItemClick(position: Int, view: ImageView) {
        Log.d("ItemClick", "$position clicked")
        if(mUsers[position].bookmarked){
             view.setImageResource(R.drawable.ic_baseline_bookmark_border_20)
        }else{
            view.setImageResource(R.drawable.ic_baseline_bookmark_20)
        }
        mUsers[position].bookmarked = !mUsers[position].bookmarked
        //mRecyclerAdapterInterface.bookmarkClicked(mUsers[position].bookmarked)
    }

    fun addItems(items: ArrayList<UserItem>) {
        mUsers.addAll(items)
        notifyDataSetChanged()
    }
}