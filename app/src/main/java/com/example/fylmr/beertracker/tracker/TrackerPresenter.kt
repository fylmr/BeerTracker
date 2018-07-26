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

    fun addAlcoClicked(vol: String, deg: String) {

    }

}