package com.example.android.feino.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AlphaAnimation
import com.example.android.feino.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : FeinoBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_splash)
        animateSplash()
        object : CountDownTimer(3000, 1000) {
            override fun onTick(l: Long) {

            }

            override fun onFinish() {

                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }

    private fun animateSplash() {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 2000
        splash_img.startAnimation(fadeIn)
    }
}