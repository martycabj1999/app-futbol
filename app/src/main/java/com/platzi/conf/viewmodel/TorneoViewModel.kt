package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.model.Torneo
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService
import java.lang.Exception

class TorneoViewModel: ViewModel() {

    val firestoreService = FirestoreService()
    var listTorneo: MutableLiveData<List<Torneo>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getTorneoFromFirebase()
    }

    fun getTorneoFromFirebase(){
        firestoreService.getTorneo(object: Callback<List<Torneo>> {
            override fun onSuccess(result: List<Torneo>?) {
                listTorneo.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }

}