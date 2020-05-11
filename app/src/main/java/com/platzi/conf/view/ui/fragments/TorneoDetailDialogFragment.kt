package com.platzi.conf.view.ui.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.platzi.conf.R
import com.platzi.conf.model.Torneo
import kotlinx.android.synthetic.main.fragment_teams_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_torneo_detail_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class TorneoDetailDialogFragment : DialogFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_torneo_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarTorneo.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarTorneo.setTitleTextColor(Color.WHITE)
        toolbarTorneo.setNavigationOnClickListener {
            dismiss()
        }

        val torneo = arguments?.getSerializable("torneo") as Torneo
        toolbarTorneo.title = torneo.name

        tvItemTorneoName.text = torneo.name
        tvDetailTorneoPuntos.text = "Puntos: " + torneo.puntos
        tvDetailTorneoWeb.text = "Sitio Web: " + torneo.website
        tvDetailTorneoPromedio.text = "Promedio: " +  torneo.promedio
        Glide.with(this)
            .load(torneo.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailTorneoImage)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}