package com.example.fylmr.beertracker.login

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*")
@PrepareForTest(FirebaseAuth::class)
class LoginActivityTest {

    @get:Rule
    var rule = PowerMockRule()

    private var testComponent = TestComponent()
    private lateinit var model: FirebaseModel

    @Before
    fun setup() {
        App.firebaseComponent = testComponent

        val auth = Mockito.mock(FirebaseAuth::class.java)
        model = FirebaseModelMock(auth)
    }

    @Test
    fun loadingShowedWhenSignInClicked() {

        val activity = Robolectric.setupActivity(LoginActivity::class.java)
        activity.loginPresenter = LoginPresenter()
        activity.loginPresenter.firebaseModel = model

        val pb = activity.findViewById<ProgressBar>(R.id.loading_pb)
        val btn = activity.findViewById<Button>(R.id.signin_btn)

        assertEquals(View.GONE, pb.visibility)
        btn.performClick()
        assertEquals(View.VISIBLE, pb.visibility)
    }

    class FirebaseModelMock(auth: FirebaseAuth) : FirebaseModel(auth) {
        override fun signIn(email: String, password: String): Single<AuthResult> {
            val mockAuthResult = LoginPresenterTest.AResult()

            return Single.just(mockAuthResult)
        }
    }
}