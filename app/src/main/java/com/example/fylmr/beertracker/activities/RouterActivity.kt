package com.example.fylmr.beertracker.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fylmr.beertracker.Constants
import com.example.fylmr.beertracker.R

class RouterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runActivity(LoginActivity::class.java)
    }

    private fun runActivity(activity: Class<out AppCompatActivity>,
                            finishThisActivity: Boolean = false) {

        val intent = Intent(this, activity)

        if (!finishThisActivity) {
            startActivityForResult(intent, Constants.RequestCodes.LOGIN_REQUEST)
            return
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
