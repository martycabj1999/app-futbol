package com.platzi.conf.view.ui.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

import com.platzi.conf.R
import com.platzi.conf.model.Torneo
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

        tvItemTorneoTituloConferencia.text = torneo.name
        tvDetailTorneoHour.text = torneo.puntos
        tvDetailTorneoSpeaker.text = torneo.website
        tvDetailTorneoTag.text = torneo.promedio
        tvDetailTorneoDescription.text = torneo.image
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}