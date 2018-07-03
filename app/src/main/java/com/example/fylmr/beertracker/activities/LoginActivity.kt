package com.example.fylmr.beertracker.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.utilities.Chronicler
import com.example.fylmr.beertracker.viewmodels.LoginViewModel
import com.example.fylmr.beertracker.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    val TAG = this::class.java.simpleName

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        setBinding()
        setListeners()
    }

    private fun setBinding() {

    }

    private fun setListeners() {
        signin_btn.setOnClickListener(this::signInClicked)
        signup_btn.setOnClickListener(this::signUpClicked)
    }

    override fun signInClicked(v: View) {
        Log.v(TAG, "signInClicked()")

        clearErrors()

        val email = email_et.text.toString()
        val password = password_et.text.toString()

        if (hasErrors(email, password)) {
            return
        }

        showLoading()

        viewModel.signIn(email, password)
                .subscribe(
                        {
                            hideLoading()
                            loginComplete()
                        },
                        { t ->
                            Chronicler.e(TAG, t)

                            hideLoading()
                        })
    }

    override fun signUpClicked(v: View) {
        Log.v(TAG, "signUpClicked()")

        clearErrors()
        showLoading()

        val email = email_et.text.toString()
        val password = password_et.text.toString()

        if (hasErrors(email, password)) {
            return
        }

        showLoading()

        viewModel.signUp(email, password)
                .subscribe(
                        {
                            hideLoading()
                            loginComplete()
                        },
                        { t ->
                            Chronicler.e(TAG, t)

                            hideLoading()
                        })
    }

    private fun hasErrors(email: String, password: String): Boolean {
        var flag = false

        if (email == "") {
            showError(email_et, resources.getString(R.string.email_field_should_not_be_empty))
            flag = true
        }

        if (password == "") {
            showError(password_et, resources.getString(R.string.password_field_should_not_be_empty))
            flag = true
        }

        return flag
    }

    override fun showLoading() {
        loading_pb.visibility = View.VISIBLE

        signin_btn.isEnabled = false
        signup_btn.isEnabled = false
    }

    override fun hideLoading() {
        loading_pb.visibility = View.GONE

        signin_btn.isEnabled = true
        signup_btn.isEnabled = true
    }

    override fun loginComplete() {
        Log.v(TAG, "loginComplete()")

        finish()
    }

    override fun showError(v: View, message: String?) {
        Log.v(TAG, "showError($message)")

        ViewCompat.setBackgroundTintList(v, ColorStateList.valueOf(Color.RED))
        showError(message)
    }

    override fun showError(message: String?) {
        Log.v(TAG, "showGenerealError($message)")

        if (message == null) return

        error_tv.visibility = View.VISIBLE
        error_tv.text = message
    }

    override fun clearErrors() {
        ViewCompat.setBackgroundTintList(email_et, ColorStateList.valueOf(Color.BLACK))
        ViewCompat.setBackgroundTintList(password_et, ColorStateList.valueOf(Color.BLACK))

        error_tv.visibility = View.GONE
    }
}
