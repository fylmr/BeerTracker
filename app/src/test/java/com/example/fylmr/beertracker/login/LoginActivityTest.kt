package com.example.fylmr.beertracker.login

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.example.fylmr.beertracker.firebase.FirebaseModelMock
import com.google.firebase.auth.FirebaseAuth
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LoginActivityTest {

    private var testComponent = TestComponent()
    private lateinit var model: FirebaseModel
    private lateinit var activity: LoginActivity

    @Before
    fun setup() {
        App.firebaseComponent = testComponent

        val auth = Mockito.mock(FirebaseAuth::class.java)
        model = FirebaseModelMock(auth)

        activity = Robolectric.setupActivity(LoginActivity::class.java)
        activity.loginPresenter = LoginPresenter()
        activity.loginPresenter.firebaseModel = model
    }

    @Test
    fun buttonDisablesWhenLoadingAndEnablesAfter() {
        val btn = activity.findViewById<Button>(R.id.signin_btn)

        assertEquals(true, btn.isEnabled)
        activity.showLoading()
        assertEquals(false, btn.isEnabled)
        activity.hideLoading()
        assertEquals(true, btn.isEnabled)
    }

    @Test
    fun progressBarShowedWhenLoadingAndHiddenAfter() {
        val pb = activity.findViewById<ProgressBar>(R.id.loading_pb)

        assertEquals(View.GONE, pb.visibility)
        activity.showLoading()
        assertEquals(View.VISIBLE, pb.visibility)
        activity.hideLoading()
        assertEquals(View.GONE, pb.visibility)
    }

    @Test
    fun coloringEditTextsWithRedOnError() {
        val emailET = activity.findViewById<EditText>(R.id.email_et)
        val passET = activity.findViewById<EditText>(R.id.password_et)

        assertEquals(null, emailET.backgroundTintList)
        assertEquals(null, passET.backgroundTintList)

        activity.showError(emailET, "Message1")
        assertEquals(ColorStateList.valueOf(Color.RED), emailET.backgroundTintList)

        activity.showError(passET, "Message2")
        assertEquals(ColorStateList.valueOf(Color.RED), passET.backgroundTintList)

        activity.clearErrors()
        assertEquals(ColorStateList.valueOf(Color.BLACK), emailET.backgroundTintList)
        assertEquals(ColorStateList.valueOf(Color.BLACK), passET.backgroundTintList)
    }

}