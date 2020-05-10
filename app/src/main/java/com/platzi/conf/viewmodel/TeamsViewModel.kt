package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.model.Team
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService


class TeamsViewModel: ViewModel() {

    val firestoreService = FirestoreService()
    var listTeam: MutableLiveData<List<Team>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getTeamFromFirebase()
    }

    fun getTeamFromFirebase() {
        firestoreService.getTeams(object : Callback<List<Team>> {
            override fun onSuccess(result: List<Team>?) {
                listTeam.postValue(result)
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