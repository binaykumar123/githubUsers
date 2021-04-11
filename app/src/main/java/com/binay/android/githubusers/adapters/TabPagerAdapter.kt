package com.binay.android.githubusers.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.binay.android.githubusers.view.fragments.BookmarkedUsersFragment
import com.binay.android.githubusers.view.fragments.UsersListFragment

class TabPagerAdapter(fragmentManager: FragmentManager, totalTabs: Int) :
    FragmentPagerAdapter(fragmentManager, totalTabs) {
    var mTotalTabs = totalTabs
    override fun getCount(): Int {
        return mTotalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> UsersListFragment()
            1 -> BookmarkedUsersFragment()
            else -> UsersListFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "All Users"
            else -> "Saved"
        }
    }
}