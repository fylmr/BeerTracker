package com.example.fylmr.beertracker

import android.app.Application
import com.example.fylmr.beertracker.dagger.*

class App : Application() {

    companion object {
        lateinit var firebaseComponent: FirebaseComponent
        lateinit var trackerComponent: TrackerComponent
    }

    override fun onCreate() {
        super.onCreate()

        firebaseComponent = DaggerFirebaseComponent.builder()
                .firebaseModule(FirebaseModule())
                .build()

        trackerComponent = DaggerTrackerComponent.builder()
                .trackerModule(TrackerModule())
                .build()
    }
}