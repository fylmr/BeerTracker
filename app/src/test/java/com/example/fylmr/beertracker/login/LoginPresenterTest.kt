package com.example.fylmr.beertracker.login

import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.firebase.FirebaseModel
import com.google.firebase.auth.AdditionalUserInfo
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(FirebaseModel::class)
class LoginPresenterTest {

    @Mock
    private
    lateinit var loginView: LoginView
    @Mock
    private
    lateinit var loginViewState: `LoginView$$State`

    private var testComponent = TestComponent()
    private val model: FirebaseModel = PowerMockito.mock(FirebaseModel::class.java)

    private lateinit var presenter: LoginPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        App.firebaseComponent = testComponent

        presenter = LoginPresenter()
        with(presenter) {
            attachView(loginView)
            setViewState(loginViewState)
            firebaseModel = model
        }
    }

    @Test
    fun signUpClickedShouldFireModel() {
        val email = "a@b.ru"
        val pass = "pass"
        val mockAuthResult = AResult()

        Mockito.`when`(model.signUp(email, pass))
                .thenReturn(Single.just(mockAuthResult))

        presenter.signUpClicked(LoginData(email, pass))

        Mockito.verify(model).signUp(email, pass)
    }

    @Test
    fun signUpClickedWithWrongEmail() {
        val email = ""
        val pass = "pass"

        presenter.signUpClicked(LoginData(email, pass))

        Mockito.verify(model, Mockito.never()).signUp(email, pass)

        Mockito.verify(loginViewState).showLoading()
        Mockito.verify(loginViewState).showError(Mockito.anyString())
    }

    class AResult : AuthResult {
        override fun getAdditionalUserInfo(): AdditionalUserInfo? {
            return null
        }

        override fun getUser(): FirebaseUser? {
            return null
        }
    }
}
