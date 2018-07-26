package com.example.fylmr.beertracker.login

import com.example.fylmr.beertracker.activities.RouterActivity
import com.example.fylmr.beertracker.dagger.FirebaseComponent
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.google.firebase.auth.FirebaseAuth


class TestComponent : FirebaseComponent {
    override fun firebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    override fun firebaseModel(): FirebaseModel {
        return FirebaseModel(firebaseAuth())
    }

    override fun inject(router: RouterActivity) {}

    override fun inject(loginPresenter: LoginPresenter) {}

}