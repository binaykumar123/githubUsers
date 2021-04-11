package com.binay.android.githubusers.adapters

import androidx.recyclerview.widget.DiffUtil
import com.binay.android.githubusers.models.UserItem

class UserDiffCallback(var oldList : List<UserItem>, var newList: List<UserItem>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }
}