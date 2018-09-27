package com.example.fylmr.beertracker.preferences

import android.content.Context
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceManager
import android.support.v7.preference.PreferenceViewHolder
import android.util.AttributeSet

abstract class CustomPreference : Preference {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override abstract fun onBindViewHolder(holder: PreferenceViewHolder?)

    fun savePref(value: String?) {
        if (value == "null" || value == null)
            return

        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        with(pref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getPref(): String? {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getString(key, "")
    }
}