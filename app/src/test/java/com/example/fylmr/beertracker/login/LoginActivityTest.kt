package com.example.fylmr.beertracker.login

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.fylmr.beertracker.App
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.firebase.FirebaseModel
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito.mock
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(PowerMockRunner::class)
@PowerMockRunnerDelegate(RobolectricTestRunner::class)
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*")
@PrepareForTest(FirebaseModel::class)
@Config(application = App::class)
class LoginActivityTest {

    lateinit var fModel: FirebaseModel

    @get:Rule
    var rule = PowerMockRule()

    @Before
    fun before() {
        mock(FirebaseModel::class.java)
    }

    @Config(application = App::class)
    @Test
    fun clickingSignInShouldShowProgressBar() {
        val activity = Robolectric.setupActivity(LoginActivity::class.java)
        val pb = activity.findViewById<ProgressBar>(R.id.loading_pb)

        activity.findViewById<Button>(R.id.signin_btn).performClick()
        assertTrue(pb.visibility == View.VISIBLE)
    }
}
