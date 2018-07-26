package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.tracker.TrackerModel
import com.example.fylmr.beertracker.tracker.TrackerPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(TrackerModule::class)])
@Singleton
interface TrackerComponent {
    fun trackerModel(): TrackerModel

    fun inject(trackerPresenter: TrackerPresenter)
}