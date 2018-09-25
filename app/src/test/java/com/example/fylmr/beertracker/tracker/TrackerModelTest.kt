package com.example.fylmr.beertracker.tracker

import com.example.fylmr.beertracker.tracker.Sex.MALE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

@Suppress("RemoveRedundantBackticks")
class TrackerModelTest {
    private val model = TrackerModelImpl()

    @Test
    fun `calc permillage with a bottle of bear`() {
        val data = DrinkData()
        data.degrees = 5.0
        data.ml = 500.0
        data.sex = MALE
        data.weight = 65.0

        val res = model.countAlco(data)
        assertNotNull(res)
        assertEquals(.5f, res!!.toFloat(), 0.1f)
    }

    @Test
    fun `calc permillage with a glass of wine`() {
        val data = DrinkData()
        data.degrees = 14.0
        data.ml = 200.0
        data.sex = MALE
        data.weight = 65.0

        val res = model.countAlco(data)
        assertNotNull(res)
        assertEquals(.5f, res!!.toFloat(), 0.1f)
    }

    @Test
    fun `calc permillage with a shot of vodka`() {
        val data = DrinkData()
        data.degrees = 40.0
        data.ml = 50.0
        data.sex = MALE
        data.weight = 65.0

        val res = model.countAlco(data)
        assertNotNull(res)
        assertEquals(.3f, res!!.toFloat(), 0.1f)
    }

    @Test
    fun `calc permillage with three bottles of beer`() {
        val data = DrinkData()
        data.degrees = 7.0
        data.ml = 1500.0
        data.sex = MALE
        data.weight = 65.0

        val res = model.countAlco(data)
        assertNotNull(res)
        assertEquals(2f, res!!.toFloat(), 0.1f)
    }
}