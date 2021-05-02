package com.binay.android.githubusers.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binay.android.githubusers.R
import com.binay.android.githubusers.adapters.UsersRecyclerViewAdapter
import com.binay.android.githubusers.interfaces.RecyclerAdapterListener
import com.binay.android.githubusers.models.UserItem


class UsersListFragment : Fragment(), RecyclerAdapterListener {
    private lateinit var mUsersRecyclerView: RecyclerView
    private lateinit var mUsersRecyclerViewAdapter: UsersRecyclerViewAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private val dummyList = ArrayList<UserItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)
        setUpView(view)
        setUpRecylerView()
        return view
    }

    private fun setUpView(view: View) {
        mUsersRecyclerView = view.findViewById(R.id.all_users_rec_view)
        mUsersRecyclerViewAdapter = UsersRecyclerViewAdapter(context!!)
        mLayoutManager = LinearLayoutManager(context)
    }

    private fun addDummyData() {
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", false))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", true))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", false))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", false))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", false))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", false))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", false))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4", true))
    }

    private fun setUpRecylerView() {
        addDummyData()
        mUsersRecyclerView.layoutManager = mLayoutManager
        mUsersRecyclerViewAdapter.addItems(dummyList)
        mUsersRecyclerView.adapter = mUsersRecyclerViewAdapter
    }

    override fun bookmarkClicked(isSelected: Boolean) {
        Log.d("UsersActivity", "bookmarkClicked: $isSelected")
    }
}