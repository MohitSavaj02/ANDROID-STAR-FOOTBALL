package com.example.baseproject.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.baseproject.R
import com.example.baseproject.app.MyApp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun after(milliSeconds: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({ action() }, milliSeconds)
}

fun Int.asString(context: Context? = null): String {
    if (context != null) return context.getString(this)
    return MyApp.getAppInstance().getString(this)
}

fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}

fun ImageView.load(data: Any?) {
    if (data is Int) {
        this.setImageResource(data)
    } else {
        Glide.with(MyApp.getAppInstance()).load(data).placeholder(R.color.placeHolder).into(this)
    }
}

fun Int.asColor(): Int {
    return MyApp.getAppInstance().getColor(this)
}

fun String.formatDate(outputPattern: String = "dd MMM yy"): String {
    try {
        val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        inputFormatter.timeZone = TimeZone.getTimeZone("UTC")
        val date: Date? = inputFormatter.parse(this)
        val outputFormatter = SimpleDateFormat(outputPattern, Locale.getDefault())
        return date?.let { outputFormatter.format(it) } ?: this
    } catch (e: Exception) {
        e.printStackTrace()
        return this
    }
}