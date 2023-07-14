package com.example.myweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.media.session.MediaSession.Token

class MyApplication: Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val Token = "hH4DuoDVs1bhLkwC"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}