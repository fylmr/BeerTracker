package com.example.fylmr.beertracker.tracker


open class TrackerModel {
    open fun countAlco(data: DrinkData): Double? {

        if (data.degrees == null)
            return null

        if (data.volume == null)
            return null

        return calcUnits(data.degrees, data.volume)
    }

    private fun calcUnits(deg: Double, ml: Double): Double =
            deg * ml / 1000

}