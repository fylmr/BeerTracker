package com.example.fylmr.beertracker.preferences

import android.content.Context
import android.support.v7.preference.PreferenceViewHolder
import android.util.AttributeSet
import android.widget.TextView
import com.example.fylmr.beertracker.R

class SexPreference : CustomPreference {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        layoutResource = R.layout.preference_sex
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
        (holder?.findViewById(R.id.sex_title_tv) as TextView?)?.text = title
    }

}