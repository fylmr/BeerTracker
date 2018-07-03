package com.example.fylmr.beertracker.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.models.FirebaseModel
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginViewModel(val app: Application): AndroidViewModel(app) {

    @Inject
    lateinit var firebaseModel: FirebaseModel

    init {
        (app as App).loginComponent.inject(this)
    }

}