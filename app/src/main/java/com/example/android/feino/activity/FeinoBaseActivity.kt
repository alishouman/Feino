package com.example.android.feino.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.MenuItem
import android.view.View
import com.example.android.feino.R

import java.util.*

open class FeinoBaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this, R.style.ProgressDialogTheme)
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

    protected open fun setToolBarWithBackBtn(@StringRes titleRes: Int) {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(true)
            supportActionBar!!.setTitle(titleRes)
        }
    }

    protected open fun changeLanguage(local: String?) {
        var local = local
        val res = resources
        val dm = res.displayMetrics
        if (local == null || local.isEmpty()) {
            local = "en"
        }
        val locale = Locale(local.toLowerCase(), if (local == "ar") "ar" else "en")
        Locale.setDefault(locale)
        val conf = res.configuration
        conf.setLocale(locale)
        res.updateConfiguration(conf, dm)
        if (Locale.getDefault().language.contains("ar"))
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        else
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissProgressDialog()
    }



}
