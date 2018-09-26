package com.example.fylmr.beertracker.tracker

import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.animation.AnimationUtils
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.R.string.alcohol_degrees
import com.example.fylmr.beertracker.preferences.SettingsActivity
import kotlinx.android.synthetic.main.activity_tracker.*
import org.koin.android.ext.android.inject
import kotlin.math.roundToInt

class TrackerActivity : MvpAppCompatActivity(), TrackerView {
    private val tag = this::class.java.simpleName

    private val trackerModel: TrackerModel by inject()

    // Moxy
    @InjectPresenter
    lateinit var trackerPresenter: TrackerPresenter

    @ProvidePresenter
    fun trackerPresenter() = TrackerPresenter(trackerModel)
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        setListeners()
    }

    private fun setListeners() {
        add_alco_btn.setOnClickListener { addAlcoClicked() }
        preferences_btn.setOnClickListener { openSettings() }
    }

    private fun openSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun addAlcoClicked() {
        val data = getDrinkData()

        trackerPresenter.addAlcoClicked(data)
    }

    private fun getDrinkData(): DrinkData {
        val deg = alco_degrees_et.text.toString()
        val vol = volume_et.text.toString()

        return DrinkData(
                deg.toDoubleOrNull(),
                vol.toDoubleOrNull())
    }

    override fun setPercents(percents: Double) {
        Log.v(tag, "setPercents($percents)")
        val txt = getString(alcohol_degrees, percents.roundToInt().toString())

        current_alco_degrees_tv.text = txt
    }

    override fun clearFields() {
        Log.v(tag, "clearFields()")
        val emptyString = ""

        volume_et.text = SpannableStringBuilder(emptyString)
        alco_degrees_et.text = SpannableStringBuilder(emptyString)
    }

    override fun showErrors(drinkDataErrors: DrinkDataErrors) {
        Log.v(tag, "showErrors($drinkDataErrors)")
        val shake = AnimationUtils.loadAnimation(this, R.anim.shake)

        if (drinkDataErrors.degreesError)
            alco_degrees_et.startAnimation(shake)

        if (drinkDataErrors.volumeError)
            volume_et.startAnimation(shake)
    }
}
