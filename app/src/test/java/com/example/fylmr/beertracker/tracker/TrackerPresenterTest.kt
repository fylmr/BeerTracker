package com.example.fylmr.beertracker.tracker

import com.example.fylmr.beertracker.App
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TrackerPresenterTest {

    @Mock
    private lateinit var trackerView: TrackerView
    @Mock
    private lateinit var trackerViewState: `TrackerView$$State`

    @Mock
    private lateinit var trackerModel: TrackerModel

    private val mockTrackerComponent = MockTrackerComponent()

    private lateinit var presenter: TrackerPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        App.trackerComponent = mockTrackerComponent

        presenter = TrackerPresenter()
        with(presenter) {
            attachView(trackerView)
            setViewState(trackerViewState)
            trackerModel = this@TrackerPresenterTest.trackerModel
        }
    }

    @Test
    fun addAlcoButton_firesModel() {
        val deg = 1.0
        val vol = 1.0
        val data = DrinkData(deg, vol)

        Mockito.`when`(trackerModel.countAlco(DrinkData(deg, vol)))
                .thenReturn(30.0)

        presenter.addAlcoClicked(data)

        Mockito.verify(trackerModel).countAlco(data)
    }

    @Test
    fun `addAlco button doesn't fire model when wrong`() {
        val deg = null
        val vol = 1.0
        val data = DrinkData(deg, vol)

        Mockito.`when`(trackerModel.countAlco(data))
                .thenReturn(null)

        presenter.addAlcoClicked(data)

        Mockito.verify(trackerModel, Mockito.never()).countAlco(data)
    }

    @Test
    fun `addAlco button pass errors to the view when wrong`() {
        val deg = null
        val vol = 1.0
        val data = DrinkData(deg, vol)

        presenter.addAlcoClicked(data)

        val expected = DrinkDataErrors(true, false)
        Mockito.verify(trackerViewState).showErrors(expected)

    }
}
