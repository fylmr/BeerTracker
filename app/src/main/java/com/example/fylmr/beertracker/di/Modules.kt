package com.example.fylmr.beertracker.di

import com.example.fylmr.beertracker.SharedPrefsModel
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.humandata.HumanDataModel
import com.example.fylmr.beertracker.humandata.HumanDataModelImpl
import com.example.fylmr.beertracker.tracker.TrackerModel
import com.example.fylmr.beertracker.tracker.TrackerModelImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val firebaseModule = module {
    single { FirebaseAuth.getInstance() }
    factory { FirebaseModel(get()) }
}

val trackerModule = module {
    single { SharedPrefsModel(androidApplication()) }
    single<HumanDataModel> { HumanDataModelImpl(get()) }
    single<TrackerModel> { TrackerModelImpl(get()) }
}
