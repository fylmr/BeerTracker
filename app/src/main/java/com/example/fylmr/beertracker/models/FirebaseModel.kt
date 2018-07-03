package com.example.fylmr.beertracker.models

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class FirebaseModel(val firebaseAuth: FirebaseAuth) {
    val TAG = this::class.java.simpleName

    init {
        Log.d(TAG, "${firebaseAuth.currentUser}")
    }


}