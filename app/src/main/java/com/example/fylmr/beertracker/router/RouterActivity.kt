package com.example.fylmr.beertracker.router

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fylmr.beertracker.Constants.RequestCodes.Companion.LOGIN_REQUEST
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.login.LoginActivity
import com.example.fylmr.beertracker.tracker.TrackerActivity
import org.koin.android.ext.android.inject

class RouterActivity : AppCompatActivity() {

    val firebaseModel: FirebaseModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        decideOnLogin()
    }

    private fun decideOnLogin() {
        if (firebaseModel.getCurrentUser() == null) {
            runActivity(LoginActivity::class.java)
            return
        }

        runActivity(TrackerActivity::class.java, true)
    }

    private fun runActivity(activity: Class<out AppCompatActivity>,
                            finishThisActivity: Boolean = false) {

        val intent = Intent(this, activity)

        if (!finishThisActivity) {
            startActivityForResult(intent, LOGIN_REQUEST)
            return
        }

        intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP or FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
