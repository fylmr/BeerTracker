package com.example.fylmr.beertracker.utilities

import android.util.Log

class Chronicler {
    companion object {

        fun e(tag: String, error: Throwable?, actualMessage: String? = null) {
            if (actualMessage != null) {
                Log.e(tag, "$actualMessage")
            }

            Log.e(tag, "Message: ${error?.localizedMessage}")

            error?.stackTrace?.forEach {
                Log.v(tag, "$it")
            }

        }
    }
}