package com.example.local_venues_frontend

import android.app.Application
import com.example.local_venues_frontend.data.AppContainer
import com.example.local_venues_frontend.data.DefaultAppContainer

class LocalVenuesApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}