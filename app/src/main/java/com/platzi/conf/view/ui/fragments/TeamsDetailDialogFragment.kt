package com.platzi.conf.view.ui.fragments


import android.content.Intent
import android.graphics.Color
import android.net.Uri
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
import com.platzi.conf.model.Team
import kotlinx.android.synthetic.main.fragment_teams_detail_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class TeamsDetailFragmentDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_teams_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.setNavigationOnClickListener {
            dismiss()
        }

        val team = arguments?.getSerializable("team") as Team
        toolbar.title = team.name
        toolbar.setTitleTextColor(Color.WHITE)

        tvDetailTeamName.text = team.name
        tvDetailTeamEntrenador.text = "Entrenador: " + team.entrenador
        tvDetailTeamEstadio.text = "Estadio: " + team.estadio
        tvDetailTeamCapacidad.text = "Capacidad: " + team.capacidad
        tvDetailTeamFundacion.text = "Fundación: " + team.fundación
        tvDetailTeamApodos.text = "Apodos: " + team.apodos
        Glide.with(this)
            .load(team.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailTeamImage)

        /*ivDetailTeamWebSite.setOnClickListener {
            var intent: Intent

            try {
                context?.packageManager?.getPackageInfo("com.twitter.android", 0)
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("${team.web}"))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception) {
                intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("${team.website}")
                )
            }
            startActivity(intent)
        }*/
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
