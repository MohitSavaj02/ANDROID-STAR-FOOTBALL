package com.example.baseproject.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StarFootballApp : Application() {
    companion object {
        lateinit var starFootballApp: StarFootballApp
        fun getAppInstance(): StarFootballApp {
            return starFootballApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        starFootballApp = this
    }
}