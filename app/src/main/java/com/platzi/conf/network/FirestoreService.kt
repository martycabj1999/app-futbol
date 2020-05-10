package com.platzi.conf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.conf.model.Torneo
import com.platzi.conf.model.Team

const val TORNEOS_COLLECTION_NAME = "torneos"
const val TEAMS_COLLECTION_NAME = "teams"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getTeams(callback: Callback<List<Team>>) {
        firebaseFirestore.collection(TEAMS_COLLECTION_NAME)
            .orderBy("name")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Team::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getTorneo(callback: Callback<List<Torneo>>) {
        firebaseFirestore.collection(TORNEOS_COLLECTION_NAME)
            .orderBy("puntos")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Torneo::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

}