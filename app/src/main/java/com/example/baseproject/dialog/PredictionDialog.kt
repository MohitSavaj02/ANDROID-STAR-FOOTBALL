package com.example.baseproject.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.content.res.AppCompatResources
import com.example.baseproject.R
import com.example.baseproject.data.PredictionResponse
import com.example.baseproject.databinding.DialogPredictionBinding
import com.example.baseproject.utils.load

class PredictionDialog(context: Context, var data: PredictionResponse.Response) : Dialog(context, R.style.ThemeDialog100) {
    private lateinit var binding: DialogPredictionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogPredictionBinding.inflate(layoutInflater)
        setCancelable(false)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        window?.setBackgroundDrawable(AppCompatResources.getDrawable(context, R.color.transparent))
        setContentView(binding.root)
        binding.apply {
            imgHomeLogo.load(data.teams?.home?.logo)
            imgAwayLogo.load(data.teams?.away?.logo)
            txtTeamHome.text = data.teams?.home?.name
            txtTeamAway.text = data.teams?.away?.name
            txtHomePrediction.text = data.predictions?.percent?.home
            txtAwayPrediction.text = data.predictions?.percent?.away
            txtDrawPrediction.text = data.predictions?.percent?.draw
            imgClose.setOnClickListener { dismiss() }
        }
    }
}
