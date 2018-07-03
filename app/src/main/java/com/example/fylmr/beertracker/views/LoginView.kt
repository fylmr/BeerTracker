package com.example.fylmr.beertracker.views

import android.view.View

interface LoginView {

    fun signInClicked(v: View)
    fun signUpClicked(v: View)

    fun clearErrors()
    fun showError(v: View, message: String?)
    fun showError(message: String?)

    fun showLoading()
    fun hideLoading()

    fun loginComplete()
}
