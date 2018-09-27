package com.example.fylmr.beertracker.preferences

import android.content.Context
import android.support.v7.preference.PreferenceViewHolder
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.widget.Button
import android.widget.EditText
import com.example.fylmr.beertracker.R

class InplaceEditTextPreference : CustomPreference {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        layoutResource = R.layout.preference_edittext
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
        super.onBindViewHolder(holder)

        val et = holder?.findViewById(R.id.pref_edittext_et) as EditText? ?: return
        et.hint = title
        et.text = SpannableStringBuilder(getPref())

        val saveBtn = holder?.findViewById(R.id.pref_edittext_save) as Button? ?: return
        saveBtn.setOnClickListener {
            savePref((holder?.findViewById(R.id.pref_edittext_et) as EditText?)?.text.toString())
        }
    }

}