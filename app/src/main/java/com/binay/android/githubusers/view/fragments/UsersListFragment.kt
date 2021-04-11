package com.binay.android.githubusers.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binay.android.githubusers.R
import com.binay.android.githubusers.adapters.UsersRecyclerViewAdapter
import com.binay.android.githubusers.models.UserItem


class UsersListFragment : Fragment() {
    private lateinit var mUsersRecyclerView: RecyclerView
    private lateinit var mUsersRecyclerViewAdapter: UsersRecyclerViewAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private val dummyList = ArrayList<UserItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
        mUsersRecyclerViewAdapter = UsersRecyclerViewAdapter()
        mLayoutManager = LinearLayoutManager(context)
    }

    private fun addDummyData() {
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
        dummyList.add(UserItem("abc", "https://avatars.githubusercontent.com/u/1?v=4"))
    }

    private fun setUpRecylerView() {
        addDummyData()
        mUsersRecyclerView.layoutManager = mLayoutManager
        mUsersRecyclerViewAdapter.addItems(dummyList)
        mUsersRecyclerView.adapter = mUsersRecyclerViewAdapter

    }
}