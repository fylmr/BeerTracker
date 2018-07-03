package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.models.FirebaseModel
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseModel(firebaseAuth: FirebaseAuth): FirebaseModel {
        return FirebaseModel(firebaseAuth)
    }

}