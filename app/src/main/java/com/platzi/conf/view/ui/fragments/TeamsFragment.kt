package com.platzi.conf.view.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.platzi.conf.R
import com.platzi.conf.model.Team
import com.platzi.conf.view.adapter.TeamsAdapter
import com.platzi.conf.view.adapter.TeamsListener
import com.platzi.conf.viewmodel.TeamsViewModel
import kotlinx.android.synthetic.main.fragment_teams.*

/**
 * A simple [Fragment] subclass.
 */
class TeamsFragment : Fragment() , TeamsListener {

    private lateinit var teamAdapter: TeamsAdapter
    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        viewModel.refresh()

        teamAdapter = TeamsAdapter(this)

        rvTeams.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = teamAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.listTeam.observe(this, Observer<List<Team>> { teams ->
            teams.let {
                teamAdapter.updateData(teams)
            }
        })

        viewModel.isLoading.observe(this, Observer<Boolean> {
            if(it != null)
                rlBase.visibility = View.INVISIBLE
        })
    }

    override fun onTeamClicked(team: Team, position: Int) {
        var bundle = bundleOf("team" to team)
        findNavController().navigate(R.id.teamsDetailFragmentDialog, bundle)
    }

}