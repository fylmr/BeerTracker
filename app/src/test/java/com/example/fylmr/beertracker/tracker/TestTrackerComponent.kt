package com.example.fylmr.beertracker.tracker

import com.example.fylmr.beertracker.dagger.TrackerComponent

class TestTrackerComponent : TrackerComponent {
    override fun trackerModel(): TrackerModel {
        return TrackerModel()
    }

    override fun inject(trackerPresenter: TrackerPresenter) {
    }

}
