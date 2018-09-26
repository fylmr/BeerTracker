package com.example.fylmr.beertracker

import android.app.Application
import android.preference.PreferenceManager
import com.example.fylmr.beertracker.Constants.Preferences.Companion.PREF_SEX
import com.example.fylmr.beertracker.Constants.Preferences.Companion.PREF_WEIGHT
import com.example.fylmr.beertracker.tracker.Sex

class SharedPrefsModel(val app: Application) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(app)

    private fun getDoubleFromPreferences(key: String, defaultValue: Double = (-1).toDouble()): Double {
        return prefs.getFloat(key, defaultValue.toFloat()).toDouble()
    }

    private fun getIntFromPreferences(key: String, defaultValue: Int = -1): Int {
        return prefs.getInt(key, defaultValue)
    }

    private fun getStringFromPreferences(key: String, defaultValue: String = ""): String? {
        return prefs.getString(key, defaultValue)
    }

    fun getSex(): Sex? {
        val sexStr = getStringFromPreferences(PREF_SEX)
        return when (sexStr) {
            "0" -> Sex.MALE
            "1" -> Sex.FEMALE
            else -> null
        }
    }

    fun getWeight(): String? {
        return getStringFromPreferences(PREF_WEIGHT)
    }
}