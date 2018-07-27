package com.example.fylmr.beertracker.tracker

import com.arellomobile.mvp.MvpView

interface TrackerView : MvpView {

    fun setPercents(percents: Double)

    fun clearFields()

    fun showErrors(drinkDataErrors: DrinkDataErrors)

}