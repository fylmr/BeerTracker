package com.example.fylmr.beertracker.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.models.FirebaseModel
import com.google.firebase.auth.AuthResult
import io.reactivex.Single
import javax.inject.Inject

class LoginViewModel(val app: Application) : AndroidViewModel(app) {
    val TAG = this::class.java.simpleName

    @Inject
    lateinit var firebaseModel: FirebaseModel

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    init {
        (app as App).loginComponent.inject(this)
    }

    fun signIn(email: String, password: String): Single<AuthResult> {
        Log.v(TAG, "signIn()")

        return firebaseModel.signIn(email, password)

    }

    fun signUp(email: String, password: String): Single<AuthResult> {
        Log.v(TAG, "signUp()")

        return firebaseModel.signUp(email, password)
    }

}