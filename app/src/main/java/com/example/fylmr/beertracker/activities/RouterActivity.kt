package com.example.fylmr.beertracker.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fylmr.beertracker.R

class RouterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runActivity(LoginActivity::class.java)
    }

    private fun runActivity(activity: Class<out AppCompatActivity>,
                            finishThisActivity: Boolean = true) {

        val intent = Intent(this, activity)

        if (finishThisActivity)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(intent)

        if (finishThisActivity)
            finish()
    }
}
