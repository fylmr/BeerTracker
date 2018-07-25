package com.example.fylmr.beertracker.firebase

import com.example.fylmr.beertracker.login.LoginPresenterTest
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single

class FirebaseModelMock(auth: FirebaseAuth) : FirebaseModel(auth) {
    override fun signIn(email: String, password: String): Single<AuthResult> {
        val mockAuthResult = LoginPresenterTest.AResult()

        return Single.just(mockAuthResult)
    }
}