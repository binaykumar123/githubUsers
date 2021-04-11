package com.binay.android.githubusers.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.binay.android.githubusers.R
import com.binay.android.githubusers.adapters.TabPagerAdapter
import com.binay.android.githubusers.adapters.UsersRecyclerViewAdapter
import com.google.android.material.tabs.TabLayout

class UsersActivity : AppCompatActivity() {
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabPagerAdapter: TabPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        initView()
        setUpTabLayout()

    }

    private fun initView() {
        mTabLayout = findViewById(R.id.tab_layout)
        mViewPager = findViewById(R.id.viewpager)
        mTabPagerAdapter = TabPagerAdapter(supportFragmentManager, 2)
    }

    private fun setUpTabLayout() {
        mTabLayout.isTabIndicatorFullWidth = false
        mViewPager.adapter = mTabPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

}