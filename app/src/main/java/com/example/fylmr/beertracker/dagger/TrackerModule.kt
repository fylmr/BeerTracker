package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.tracker.TrackerModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TrackerModule {

    @Provides
    @Singleton
    fun provideTrackerModel() =
            TrackerModel()
}