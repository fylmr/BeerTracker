package com.example.fylmr.beertracker.tracker

interface TrackerModel {
    fun countAlco(data: DrinkData): Double?
    fun addAlco(data: DrinkData): Double?
}