package com.example.fylmr.beertracker.login

import com.example.fylmr.beertracker.dagger.FirebaseComponent
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.router.RouterActivity
import com.google.firebase.auth.FirebaseAuth


class TestFirebaseComponent : FirebaseComponent {
    override fun firebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    override fun firebaseModel(): FirebaseModel {
        return FirebaseModel(firebaseAuth())
    }

    override fun inject(router: RouterActivity) {}

    override fun inject(loginPresenter: LoginPresenter) {}

}