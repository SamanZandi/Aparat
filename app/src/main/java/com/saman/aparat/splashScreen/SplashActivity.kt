package com.saman.aparat.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saman.aparat.MainActivity
import com.saman.aparat.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


       val splashScreenStarter: Thread = object : Thread() {
            override fun run() {
                try {
                    var delay = 0
                    while (delay < 2000) {
                        sleep(150)
                        delay = delay + 100
                    }
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    finish()
                }
            }
        }
        splashScreenStarter.start()
    }

}