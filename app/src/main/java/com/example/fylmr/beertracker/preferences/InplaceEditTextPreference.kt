package com.example.fylmr.beertracker.preferences

import android.content.Context
import android.support.v7.preference.PreferenceViewHolder
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import com.example.fylmr.beertracker.R

class InplaceEditTextPreference : CustomPreference {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        layoutResource = R.layout.preference_edittext
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
//        super.onBindViewHolder(holder)

        with(holder?.findViewById(R.id.pref_edittext_et) as EditText? ?: return) {
            text = SpannableStringBuilder(getPref())
            setOnEditorActionListener { v, actionId, event ->
                savePref((holder?.findViewById(R.id.pref_edittext_et) as EditText?)?.text.toString())
                return@setOnEditorActionListener true
            }
        }

        with(holder?.findViewById(R.id.inplace_pref_title_tv) as TextView? ?: return) {
            text = title
        }
    }

}