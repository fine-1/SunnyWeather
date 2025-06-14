package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.sunnyweather.android.logic.network.ServiceCreator
import com.sunnyweather.android.logic.network.WeatherService
import retrofit2.await

class SunnyWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "JHqblTV4iz2lsDKH"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}