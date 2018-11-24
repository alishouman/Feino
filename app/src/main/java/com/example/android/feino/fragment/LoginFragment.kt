package com.example.android.feino.fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.feino.FeinoApplication
import com.example.android.feino.R
import com.example.android.feino.util.DialogMaker
import com.example.android.feino.util.PreferenceHelper
import com.google.firebase.iid.FirebaseInstanceId
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import javax.inject.Inject

class LoginFragment : FeinoBaseFragment() {

    @Inject
    lateinit var preferenceHelper: PreferenceHelper
    private var communicator: LoginCommunicator? = null
    private val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity?.application as FeinoApplication).getComponent().inject(this)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideToolbar()
        setClickListeners()
    }

    private fun setClickListeners() {

     /*   loginBtn.setOnClickListener {
            val checkEmailResult = loginViewModel.checkEmail(emailEditText.text.toString())
            val checkPasswordResult = loginViewModel.checkPassword(passwordEditText.text.toString())
            if (checkEmailResult.first == true && checkPasswordResult.first == true) {
                callLoginService(LoginRequest(emailEditText.text.toString(), passwordEditText.text.toString(), FirebaseInstanceId.getInstance().token.toString()))
            } else if (checkEmailResult.first == false) {
                emailEditText.error = getString(checkEmailResult.second)
            } else if (checkPasswordResult.first == false) {
                passwordEditText.error = getString(checkPasswordResult.second)
            }
        }*/
    }

   /* private fun callLoginService(loginRequest: LoginRequest) {
        showProgressDialog()
        val disposable = loginViewModel.login(loginRequest).subscribe({
            dismissProgressDialog()
            DialogMaker.makeDialog(activity, getString(R.string.app_name), getString(R.string.ok), null).show()
            //navigate to home
            //navigateToHome()

        }, {
            dismissProgressDialog()
            if (it is HandymanThrowable) {
                DialogMaker.makeDialog(activity, getString(it.handymanCodeEnum.messageIndex), getString(R.string.ok), null).show()
            } else {
                DialogMaker.makeDialog(activity, getString(R.string.error), getString(R.string.ok), null).show()
            }
        })
        compositeDisposable?.add(disposable);

    }*/


    interface LoginCommunicator {

        fun launchFragment(fragment: FeinoBaseFragment, addToBackStack: Boolean, animate: Boolean)

    }
}
