package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.model.Torneo
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService


class SpeakersViewModel: ViewModel() {

    val firestoreService = FirestoreService()
    var listSpeaker: MutableLiveData<List<Torneo>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }

    fun getSpeakerFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Torneo>> {
            override fun onSuccess(result: List<Torneo>?) {
                listSpeaker.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()

            }
        })
    }

    private fun processFinished() {
        isLoading.value = true
    }

}