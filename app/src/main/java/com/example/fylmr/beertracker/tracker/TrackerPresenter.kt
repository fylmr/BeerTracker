package com.example.fylmr.beertracker.tracker

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.fylmr.beertracker.App
import javax.inject.Inject

@InjectViewState
class TrackerPresenter : MvpPresenter<TrackerView>() {
    val TAG = this::class.java.simpleName

    @Inject
    lateinit var trackerModel: TrackerModel

    init {
        App.trackerComponent.inject(this)
    }

    fun addAlcoClicked(drinkData: DrinkData) {

        val errors = checkForErrors(drinkData)

        if (errors.degreesError || errors.volumeError) {
            viewState.showErrors(errors)
            Log.v(TAG, "viewstate.showerrors($errors)")
            return
        }

        val alco = trackerModel.countAlco(drinkData)
        if (alco != null)
            viewState.setPercents(alco)
    }

    private fun checkForErrors(drinkData: DrinkData): DrinkDataErrors {
        val errors = DrinkDataErrors()

        if (drinkData.degrees == null)
            errors.degreesError = true

        if (drinkData.volume == null)
            errors.volumeError = true

        return errors
    }

}