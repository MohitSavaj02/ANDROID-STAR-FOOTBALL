package com.example.baseproject.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.content.res.AppCompatResources
import com.example.baseproject.R
import com.example.baseproject.databinding.DialogLoadingBinding

class LoadingDialog(context: Context) : Dialog(context, R.style.ThemeDialog100) {
    private lateinit var binding: DialogLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogLoadingBinding.inflate(layoutInflater)
        setCancelable(false)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        window?.setBackgroundDrawable(AppCompatResources.getDrawable(context, R.color.transparent))
        setContentView(binding.root)
    }
}
