package com.example.android.feino.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.android.feino.R

open class FeinoBaseFragment: Fragment() {
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(context, R.style.ProgressDialogTheme)
        progressDialog!!.setCancelable(false)
    }

    protected open fun showProgressDialog() {
        if (progressDialog != null && !progressDialog!!.isShowing) {
            progressDialog!!.show()
        }
    }

    protected open fun dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
        }
    }

    protected open fun setToolbarWithBackBtn(@StringRes titleRes: Int, withBackButton : Boolean) {
        if ((activity as AppCompatActivity).supportActionBar != null) {
            setToolbar(withBackButton)
            (activity as AppCompatActivity).supportActionBar!!.setTitle(titleRes)
        }
    }

    protected open fun setToolbarWithBackBtn(title: String, withBackButton : Boolean) {
        if ((activity as AppCompatActivity).supportActionBar != null) {
            setToolbar(withBackButton)
            (activity as AppCompatActivity).supportActionBar!!.title = title
        }
    }

    protected fun hideToolbar() {
        if ((activity as AppCompatActivity).supportActionBar != null) {
            (activity as AppCompatActivity).supportActionBar!!.hide()
        }
    }

    private fun setToolbar(backButtonEnabled: Boolean?) {
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(backButtonEnabled!!)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowTitleEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissProgressDialog()
    }
}