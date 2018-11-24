package com.example.android.feino.fragment

import android.os.Build
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.feino.R
import com.example.android.feino.activity.HomeActivity
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : FeinoBaseFragment(){
    lateinit var pageAdapter: PageAdapter
    interface HomeCommunicator {

        fun launchFragment(fragment: FeinoBaseFragment, addToBackStack: Boolean, animate: Boolean)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        setHasOptionsMenu(false)
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageAdapter = PageAdapter(childFragmentManager, tablayout.tabCount)
        viewPager.adapter = pageAdapter

        tablayout.setBackgroundColor(
            ContextCompat.getColor(
                activity as HomeActivity,
                R.color.primaryColor
            )
        )

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity?.window?.statusBarColor = ContextCompat.getColor(
                activity as HomeActivity,
                R.color.primaryColor
            )
        }

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }


            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))
    }
}