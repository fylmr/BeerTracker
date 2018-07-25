package com.example.fylmr.beertracker.login

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.util.Log
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.fylmr.beertracker.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {

    val TAG = this::class.java.simpleName

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()
    }

    private fun setListeners() {
        signin_btn.setOnClickListener(this::signInClicked)
        signup_btn.setOnClickListener(this::signUpClicked)
    }

    private fun getLoginData(): LoginData {
        val email = email_et.text.toString()
        val password = password_et.text.toString()

        return LoginData(email, password)
    }

    override fun signInClicked(v: View) {
        loginPresenter.signInClicked(getLoginData())
    }

    override fun signUpClicked(v: View) {
        loginPresenter.signUpClicked(getLoginData())
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
