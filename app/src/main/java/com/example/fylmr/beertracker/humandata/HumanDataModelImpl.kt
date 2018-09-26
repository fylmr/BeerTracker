package com.example.fylmr.beertracker.humandata

import com.example.fylmr.beertracker.SharedPrefsModel
import com.example.fylmr.beertracker.tracker.Sex

class HumanDataModelImpl(private val sharedPrefsModel: SharedPrefsModel) : HumanDataModel {

    override var weight: Double? = null
        get() = readWeightFromSharedPrefs()

    override var sex: Sex? = null
        get() = readSexFromSharedPrefs()

    private fun readSexFromSharedPrefs(): Sex? {
        return sharedPrefsModel.getSex()
    }

    private fun readWeightFromSharedPrefs(): Double? {
        val weight = sharedPrefsModel.getWeight()?.toDoubleOrNull() ?: return null

        if (weight <= 0)
            return null

        return weight
    }

}