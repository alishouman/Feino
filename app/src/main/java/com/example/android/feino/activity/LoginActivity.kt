package com.example.android.feino.activity

import android.os.Bundle
import com.example.android.feino.FeinoApplication
import com.example.android.feino.R
import com.example.android.feino.fragment.FeinoBaseFragment


class LoginActivity : FeinoBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as FeinoApplication).getComponent().inject(this)

        launchFragment(LoginFragment(), true, false)
    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack();
        } else {
            super.onBackPressed()
        }
    }


    override fun launchFragment(fragment: FeinoBaseFragment, addToBackStack: Boolean, animate: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        if (animate){}
        //   transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
        if (addToBackStack) {
            transaction
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        } else {
            transaction.add(R.id.fragment_container, fragment).commitAllowingStateLoss()
        }
    }

}
