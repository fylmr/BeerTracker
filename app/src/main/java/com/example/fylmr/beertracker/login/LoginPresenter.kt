package com.example.fylmr.beertracker.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.utilities.Chronicler
import com.google.firebase.auth.AuthResult
import io.reactivex.Single
import javax.inject.Inject

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    val TAG = this::class.java.simpleName

    @Inject
    lateinit var firebaseModel: FirebaseModel

    init {
        App.firebaseComponent.inject(this)
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

        val emailError = emailErrors(email)
        val passwordError = passwordErrors(password)

        if (emailError != null)
            viewState.showError(emailError)

        if (passwordError != null)
            viewState.showError(passwordError)

        if (passwordError != null || emailError != null) {
            viewState.hideLoading()
            return
        }

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

    private fun emailErrors(email: String): String? {
        var message: String? = null

        if (email == "")
            message = "Email is empty"

        return message
    }

    private fun passwordErrors(password: String): String? {
        var message: String? = null

        if (password == "")
            message = "Password is empty"

        return message
    }
}
