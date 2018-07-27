package com.example.fylmr.beertracker.tracker

data class DrinkData(
        var degrees: Double?,
        var volume: Double?
)

data class DrinkDataErrors(
        var degreesError: Boolean = false,
        var volumeError: Boolean = false
)