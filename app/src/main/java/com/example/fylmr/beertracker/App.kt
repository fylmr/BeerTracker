package com.example.fylmr.beertracker

import android.app.Application
import com.example.fylmr.beertracker.dagger.DaggerFirebaseComponent
import com.example.fylmr.beertracker.dagger.FirebaseComponent
import com.example.fylmr.beertracker.dagger.FirebaseModule

class App : Application() {

    companion object {
        lateinit var firebaseComponent: FirebaseComponent
    }

    override fun onCreate() {
        super.onCreate()

        firebaseComponent = DaggerFirebaseComponent.builder()
                .firebaseModule(FirebaseModule())
                .build()
    }
}