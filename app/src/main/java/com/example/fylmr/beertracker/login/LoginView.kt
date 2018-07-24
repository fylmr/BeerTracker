package com.example.fylmr.beertracker.login

import android.view.View
import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {

    fun signInClicked(v: View)
    fun signUpClicked(v: View)

    fun clearErrors()
    fun showError(v: View, message: String?)
    fun showError(message: String?)

    fun showLoading()
    fun hideLoading()

    fun loginComplete()
}
