package com.example.fylmr.beertracker.tracker

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.R.string.alcohol_degrees
import kotlinx.android.synthetic.main.activity_tracker.*
import kotlin.math.roundToInt

class TrackerActivity : MvpAppCompatActivity(), TrackerView {
    val TAG = this::class.java.simpleName

    @InjectPresenter
    lateinit var trackerPresenter: TrackerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)
    }

    override fun setPercents(percents: Double) {
        Log.v(TAG, "setPercents($percents)")
        val txt = getString(alcohol_degrees, percents.roundToInt().toString())

        current_alco_degrees_tv.text = txt
    }

    override fun clearFields() {
        Log.v(TAG, "clearFields()")
        val emptyString = ""

        volume_et.text = SpannableStringBuilder(emptyString)
        alco_degrees_et.text = SpannableStringBuilder(emptyString)
    }
}
