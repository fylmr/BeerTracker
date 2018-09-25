package com.example.fylmr.beertracker.di

import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.tracker.TrackerModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module.module

val firebaseModule = module {
    single { FirebaseAuth.getInstance() }
    factory { FirebaseModel(get()) }
}

val trackerModule = module {
    single { TrackerModel() }
}