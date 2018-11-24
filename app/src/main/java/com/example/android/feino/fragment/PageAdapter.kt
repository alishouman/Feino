package com.example.android.feino.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class PageAdapter internal constructor(fm: FragmentManager, private val numOfTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return HomeFragment()
            1 -> return AlertFragment()
            2 -> return ProfileFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}