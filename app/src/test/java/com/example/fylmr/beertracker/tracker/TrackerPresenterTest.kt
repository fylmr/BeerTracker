package com.example.fylmr.beertracker.tracker

import android.util.Log
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
@PrepareForTest(Log::class)
class TrackerPresenterTest {

    @Mock
    private lateinit var trackerView: TrackerView
    @Mock
    private lateinit var trackerViewState: `TrackerView$$State`

    @Mock
    private lateinit var trackerModel: TrackerModel

    private lateinit var presenter: TrackerPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        PowerMockito.mockStatic(Log::class.java)

        presenter = TrackerPresenter(trackerModel)
        with(presenter) {
            attachView(trackerView)
            setViewState(trackerViewState)
        }
    }

    @Test
    fun `addAlco fires model`() {
        val deg = 1.0
        val vol = 1.0
        val data = DrinkData(deg, vol)

        Mockito.`when`(trackerModel.countAlco(DrinkData(deg, vol)))
                .thenReturn(30.0)

        presenter.addAlcoClicked(data)

        Mockito.verify(trackerModel).countAlco(data)
    }

    @Test
    fun `addAlco doesn't fire model when wrong`() {
        val deg = null
        val vol = 1.0
        val data = DrinkData(deg, vol)

        Mockito.`when`(trackerModel.countAlco(data))
                .thenReturn(null)

        presenter.addAlcoClicked(data)

        Mockito.verify(trackerModel, Mockito.never()).countAlco(data)
    }

    @Test
    fun `addAlco passes errors to the view when wrong degrees`() {
        val deg = null
        val vol = 1.0
        val data = DrinkData(deg, vol)

        presenter.addAlcoClicked(data)

        val expected = DrinkDataErrors(true, false)
        Mockito.verify(trackerViewState).showErrors(expected)
        Mockito.verify(trackerModel, Mockito.never()).countAlco(data)
    }

    @Test
    fun `addAlco passes errors to the view when wrong vol`() {
        val deg = 1.0
        val vol = null
        val data = DrinkData(deg, vol)

        presenter.addAlcoClicked(data)

        val expected = DrinkDataErrors(false, true)
        Mockito.verify(trackerViewState).showErrors(expected)
        Mockito.verify(trackerModel, Mockito.never()).countAlco(data)
    }


}
