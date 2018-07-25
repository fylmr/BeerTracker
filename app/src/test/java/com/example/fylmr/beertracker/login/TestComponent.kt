package com.example.fylmr.beertracker.login

import com.example.fylmr.beertracker.activities.RouterActivity
import com.example.fylmr.beertracker.dagger.FirebaseComponent


class TestComponent : FirebaseComponent {
    override fun inject(router: RouterActivity) {}

    override fun inject(loginPresenter: LoginPresenter) {}

}