package com.example.fylmr.beertracker.firebase

import com.example.fylmr.beertracker.utilities.Chronicler
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single

class FirebaseModel(val firebaseAuth: FirebaseAuth) {
    val TAG = this::class.java.simpleName

    fun getCurrentUser() =
            firebaseAuth.currentUser

    fun logout() =
            firebaseAuth.signOut()


    fun signIn(email: String, password: String): Single<AuthResult> =
            Single.create { emitter ->
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            emitter.onSuccess(it)
                        }
                        .addOnFailureListener {
                            Chronicler.e(TAG, it)

                            emitter.onError(it)
                        }
            }

    fun signUp(email: String, password: String): Single<AuthResult> =
            Single.create { emitter ->
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            emitter.onSuccess(it)
                        }
                        .addOnFailureListener {
                            Chronicler.e(TAG, it)

                            emitter.onError(it)
                        }
            }
}