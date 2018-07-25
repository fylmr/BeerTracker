package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.activities.RouterActivity
import com.example.fylmr.beertracker.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(FirebaseModule::class)])
@Singleton
interface FirebaseComponent {
    fun inject(router: RouterActivity)
    fun inject(loginPresenter: LoginPresenter)
}