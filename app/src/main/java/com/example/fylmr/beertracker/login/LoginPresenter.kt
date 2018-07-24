package com.example.fylmr.beertracker.login

import android.app.Application
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.utilities.Chronicler
import com.google.firebase.auth.AuthResult
import io.reactivex.Single
import javax.inject.Inject

@InjectViewState
class LoginPresenter(val app: Application) : MvpPresenter<LoginView>() {
    val TAG = this::class.java.simpleName

    @Inject
    lateinit var firebaseModel: FirebaseModel

    init {
        (app as App).loginComponent.inject(this)
    }

    fun signInClicked(loginData: LoginData) {
        process(loginData, firebaseModel::signIn)
    }

    fun signUpClicked(loginData: LoginData) {
        process(loginData, firebaseModel::signUp)
    }

    private fun process(loginData: LoginData,
                        processMethod: (email: String, password: String) -> Single<AuthResult>) {
        val email = loginData.email
        val password = loginData.password

        viewState.clearErrors()
        viewState.showLoading()

        if (hasErrors(email, password))
            return

        viewState.showLoading()

        processMethod(email, password)
                .subscribe(
                        {
                            viewState.hideLoading()
                            viewState.loginComplete()
                        },
                        { t ->
                            Chronicler.e(TAG, t)
                            viewState.hideLoading()
                        })
    }

    private fun hasErrors(email: String, password: String): Boolean {
        var flag = false

        if (email == "") {
            flag = true
        }

        if (password == "") {
            flag = true
        }

        return flag
    }
}