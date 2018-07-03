package com.example.fylmr.beertracker

import android.app.Application
import com.example.fylmr.beertracker.dagger.DaggerLoginComponent
import com.example.fylmr.beertracker.dagger.FirebaseModule
import com.example.fylmr.beertracker.dagger.LoginComponent

class App : Application() {
    lateinit var loginComponent: LoginComponent

    override fun onCreate() {
        super.onCreate()

        loginComponent = DaggerLoginComponent.builder()
                .firebaseModule(FirebaseModule())
                .build()
    }
}