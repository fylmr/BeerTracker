package com.example.fylmr.beertracker.humandata

import com.example.fylmr.beertracker.SharedPrefsModel
import com.example.fylmr.beertracker.tracker.Sex
import com.example.fylmr.beertracker.tracker.Sex.FEMALE
import com.example.fylmr.beertracker.tracker.Sex.MALE

class HumanDataModelImpl(val sharedPrefsModel: SharedPrefsModel) : HumanDataModel {

    override var weight: Double? = null
        get() = readWeightFromSharedPrefs()

    override var sex: Sex? = null
        get() = readSexFromSharedPrefs()

    private fun readSexFromSharedPrefs(): Sex? {
        val sexInt = sharedPrefsModel.getSex()
        return when (sexInt) {
            0 -> MALE
            1 -> FEMALE
            else -> null
        }
    }

    private fun readWeightFromSharedPrefs(): Double? {
        val weight = sharedPrefsModel.getWeight()

        if (weight <= 0)
            return null

        return weight
    }

}