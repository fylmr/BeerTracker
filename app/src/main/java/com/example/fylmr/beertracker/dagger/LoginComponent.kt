package com.example.fylmr.beertracker.dagger

import com.example.fylmr.beertracker.dagger.FirebaseModule
import com.example.fylmr.beertracker.models.FirebaseModel
import com.example.fylmr.beertracker.viewmodels.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(FirebaseModule::class)])
@Singleton
interface LoginComponent {
    fun inject(viewModel: LoginViewModel)
}