package com.example.fylmr.beertracker.tracker

import com.example.fylmr.beertracker.tracker.Sex.*


open class TrackerModel {
    open fun countAlco(data: DrinkData): Double? {
        return calcPermillage(data)
    }

    private fun calcUnits(deg: Double?, ml: Double?): Double? {
        if (deg == null || ml == null)
            return null

        return deg * ml / 1000
    }

    private fun calcStandardDrinks(deg: Double?, ml: Double?): Double? {
        if (deg == null || ml == null)
            return null

        val density = 789.24

        val mass = ml / 1000 * deg / 100 * density
        return mass / 10
    }

    private fun calcPermillage(data: DrinkData): Double? {
        val deg = data.degrees
        val ml = data.ml
        val sex = data.sex
        val weight = data.weight
        if (deg == null || ml == null || sex == null || weight == null)
            return null

        val bodyWaterInBlood = 0.806
        val standardDrink = calcStandardDrinks(deg, ml) ?: return null
        val factor = 1.2
        val bodyWaterConst = when (sex) {
            MALE -> 0.58
            FEMALE -> 0.49
        }
        val metabolismConst = when (sex) {
            MALE -> 0.015
            FEMALE -> 0.017
        }
        val drinkingPeriod = 0.5 // May be changed later
        val permillageConst = 10

        var res = bodyWaterInBlood * standardDrink * factor
        res /= weight * bodyWaterConst
        res -= metabolismConst * drinkingPeriod
        res *= permillageConst

        return res
    }

}