package com.example.fylmr.beertracker

import android.app.Application
import com.example.fylmr.beertracker.di.firebaseModule
import com.example.fylmr.beertracker.di.humanDataModel
import com.example.fylmr.beertracker.di.trackerModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                firebaseModule,
                trackerModule,
                humanDataModel
        ))

    }
}