package com.example.android.feino.activity

import android.os.Bundle
import com.example.android.feino.R
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.os.Build
import com.example.android.feino.fragment.FeinoBaseFragment
import com.example.android.feino.fragment.PageAdapter
import com.example.android.feino.fragment.PageFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : FeinoBaseActivity(), PageFragment.HomeCommunicator {
    lateinit var pageAdapter: PageAdapter


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
         launchFragment(PageFragment(), true, false)


    }
    override fun launchFragment(fragment: FeinoBaseFragment, addToBackStack: Boolean, animate: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        if (animate)
            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
        if (addToBackStack) {
            transaction
                .replace(R.id.home_fragments_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        } else {
            transaction.add(R.id.home_fragments_container, fragment).commitAllowingStateLoss()
        }
    }
}