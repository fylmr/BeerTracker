package com.example.fylmr.beertracker.tracker

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class TrackerPresenter(val trackerModel: TrackerModel) : MvpPresenter<TrackerView>() {
    val TAG = this::class.java.simpleName

    fun addAlcoClicked(drinkData: DrinkData) {

        val errors = checkForErrors(drinkData)

        if (errors.degreesError || errors.volumeError) {
            viewState.showErrors(errors)
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