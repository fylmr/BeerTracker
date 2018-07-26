package com.example.fylmr.beertracker.tracker

import com.example.fylmr.beertracker.App
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TrackerPresenterTest {

    @Mock
    private
    lateinit var trackerView: TrackerView

    @Mock
    private
    lateinit var trackerViewState: `TrackerView$$State`

    private val testTrackerComponent = TestTrackerComponent()
    private val model: TrackerModel = Mockito.mock(TrackerModel::class.java)

    private lateinit var presenter: TrackerPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        App.trackerComponent = testTrackerComponent

        presenter = TrackerPresenter()
        with(presenter) {
            attachView(trackerView)
            setViewState(trackerViewState)
            trackerModel = model
        }
    }
//
//    @Test
//    fun addAlcoButton_firesModel() {
//        val deg = "1"
//        val vol = "1"
//
//        Mockito.`when`(model.)
//    }
}
