package com.app.badiyashopping.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.badiyashopping.R

class SplashActivity : AppCompatActivity() {
    var SPLASH_DELAY_TIMMING: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this, AuthActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DELAY_TIMMING)
    }
}