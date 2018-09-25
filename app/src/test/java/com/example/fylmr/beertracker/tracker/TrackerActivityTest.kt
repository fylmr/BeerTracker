package com.example.fylmr.beertracker.tracker

import android.text.SpannableStringBuilder
import android.widget.EditText
import android.widget.TextView
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.humandata.HumanDataModelImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*")
class TrackerActivityTest {
    @get:Rule
    var rule = PowerMockRule()

    private lateinit var activity: TrackerActivity

    @Mock
    private lateinit var trackerModel: TrackerModelImpl
    @Mock
    private lateinit var humanDataModel: HumanDataModelImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        activity = Robolectric.setupActivity(TrackerActivity::class.java)
        activity.trackerPresenter = TrackerPresenter(trackerModel, humanDataModel)
    }

    @Test
    fun `setting degrees changes TextView`() {
        val tv = activity.findViewById<TextView>(R.id.current_alco_degrees_tv)

        assertEquals("0%", tv.text.toString())
        activity.setPercents(15.0)
        assertEquals("15%", tv.text.toString())
    }

    @Test
    fun `EditTexts are cleared after clearFields called`() {
        val degEt = activity.findViewById<EditText>(R.id.alco_degrees_et)
        val volEt = activity.findViewById<EditText>(R.id.volume_et)

        degEt.text = SpannableStringBuilder("123")
        volEt.text = SpannableStringBuilder("356")
        assertEquals("123", degEt.text.toString())
        assertEquals("356", volEt.text.toString())

        activity.clearFields()
        assertEquals("", degEt.text.toString())
        assertEquals("", volEt.text.toString())
    }
}