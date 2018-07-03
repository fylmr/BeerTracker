package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.activities.RouterActivity
import com.example.fylmr.beertracker.viewmodels.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(FirebaseModule::class)])
@Singleton
interface LoginComponent {
    fun inject(viewModel: LoginViewModel)
    fun inject(router: RouterActivity)
}