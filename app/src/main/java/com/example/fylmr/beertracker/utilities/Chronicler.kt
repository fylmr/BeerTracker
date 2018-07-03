package com.example.fylmr.beertracker.utilities

import android.util.Log

class Chronicler {
    companion object {

        fun e(tag: String, error: Throwable) {

            Log.e(tag, "Message: ${error.localizedMessage}")

            error.stackTrace?.forEach {
                Log.v(tag, "$it")
            }

        }
    }
}