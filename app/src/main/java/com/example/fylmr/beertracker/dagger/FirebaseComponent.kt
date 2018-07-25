package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.activities.RouterActivity
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.login.LoginPresenter
import com.google.firebase.auth.FirebaseAuth
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(FirebaseModule::class)])
@Singleton
interface FirebaseComponent {
    fun firebaseAuth(): FirebaseAuth
    fun firebaseModel(): FirebaseModel

    fun inject(router: RouterActivity)
    fun inject(loginPresenter: LoginPresenter)
}