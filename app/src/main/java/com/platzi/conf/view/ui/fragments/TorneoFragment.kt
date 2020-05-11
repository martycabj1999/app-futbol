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
import androidx.recyclerview.widget.LinearLayoutManager

import com.platzi.conf.R
import com.platzi.conf.model.Torneo
import com.platzi.conf.view.adapter.TorneoAdapter
import com.platzi.conf.view.adapter.TorneoListener
import com.platzi.conf.viewmodel.TorneoViewModel
import kotlinx.android.synthetic.main.fragment_torneo.*

/**
 * A simple [Fragment] subclass.
 */
class TorneoFragment : Fragment(), TorneoListener {

    private lateinit var torneoAdapter: TorneoAdapter
    private lateinit var viewModel: TorneoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_torneo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TorneoViewModel::class.java)
        viewModel.refresh()

        torneoAdapter = TorneoAdapter(this)

        rvTorneo.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = torneoAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.listTorneo.observe(this, Observer<List<Torneo>> { torneo  ->
            torneoAdapter.updateData(torneo)
        })

        viewModel.isLoading.observe(this, Observer<Boolean> {
            if(it != null)
                rlBaseTorneo.visibility = View.INVISIBLE
        })
    }

    override fun onTorneoClicked(torneo: Torneo, position: Int) {
        print("Torneo: ")
        println(torneo)
        println(torneo.name)

        val bundle = bundleOf("torneo" to torneo)
        findNavController().navigate(R.id.torneoDetailFragmentDialog, bundle)
    }


}

