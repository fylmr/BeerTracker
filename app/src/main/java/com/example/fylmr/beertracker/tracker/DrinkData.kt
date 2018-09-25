package com.example.fylmr.beertracker.tracker

data class DrinkData(
        var degrees: Double? = null,
        var ml: Double? = null,
        var sex: Sex? = null,
        var weight: Double? = null
)

enum class Sex {
    MALE, FEMALE
}

data class DrinkDataErrors(
        var degreesError: Boolean = false,
        var volumeError: Boolean = false
)