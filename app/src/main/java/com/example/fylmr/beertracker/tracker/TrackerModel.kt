package com.example.fylmr.beertracker.tracker


open class TrackerModel {
    open fun countAlco(data: DrinkData): Double? {

        if (data.degrees == null)
            return null

        if (data.volume == null)
            return null

        return calcUnits(data.degrees, data.volume)
    }

    private fun calcUnits(deg: Double?, ml: Double?): Double? {
        if (deg == null || ml == null)
            return null

        return deg * ml / 1000

    }
}