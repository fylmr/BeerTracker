package com.example.fylmr.beertracker.tracker

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.fylmr.beertracker.humandata.HumanDataModel

@InjectViewState
class TrackerPresenter(
        private val trackerModel: TrackerModel,
        private val humanDataModel: HumanDataModel
) : MvpPresenter<TrackerView>() {

    private val tag = this::class.java.simpleName

    fun addAlcoClicked(drinkData: DrinkData) {

        val errors = checkForErrors(drinkData)

        if (errors.degreesError || errors.volumeError) {
            viewState.showErrors(errors)
            return
        }

        drinkData.sex = humanDataModel.sex
        drinkData.weight = humanDataModel.weight

        val alco = trackerModel.countAlco(drinkData)
        Log.v(tag, "Count alco result: $alco")

        if (alco != null)
            viewState.setPercents(alco)
    }

    private fun checkForErrors(drinkData: DrinkData): DrinkDataErrors {
        val errors = DrinkDataErrors()

        if (drinkData.degrees == null)
            errors.degreesError = true

        if (drinkData.ml == null)
            errors.volumeError = true

        return errors
    }

}