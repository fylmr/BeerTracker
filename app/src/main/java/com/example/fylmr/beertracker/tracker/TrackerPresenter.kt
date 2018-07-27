package com.example.fylmr.beertracker.tracker

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.fylmr.beertracker.App
import javax.inject.Inject

@InjectViewState
class TrackerPresenter : MvpPresenter<TrackerView>() {

    @Inject
    lateinit var trackerModel: TrackerModel

    init {
        App.trackerComponent.inject(this)
    }

    fun addAlcoClicked(drinkData: DrinkData) {
        if (drinkData.volume == null)
            return

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