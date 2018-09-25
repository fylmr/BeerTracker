package com.example.fylmr.beertracker

import android.app.Application
import android.content.Context.MODE_PRIVATE
import com.example.fylmr.beertracker.Constants.Preferences.Companion.FILE_NAME
import com.example.fylmr.beertracker.Constants.Preferences.Companion.PREF_SEX
import com.example.fylmr.beertracker.Constants.Preferences.Companion.PREF_WEIGHT

class SharedPrefsModel(val app: Application) {
    private val prefs = app.getSharedPreferences(FILE_NAME, MODE_PRIVATE)

    private fun getDoubleFromPreferences(key: String, defaultValue: Double = (-1).toDouble()): Double {
        return prefs.getFloat(key, defaultValue.toFloat()).toDouble()
    }

    private fun getIntFromPreferences(key: String, defaultValue: Int = -1): Int {
        return prefs.getInt(key, defaultValue)
    }

    fun getSex(): Int {
        return getIntFromPreferences(PREF_SEX)
    }

    fun getWeight(): Double {
        return getDoubleFromPreferences(PREF_WEIGHT)
    }
}