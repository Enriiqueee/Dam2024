package edu.iesam.dam2024.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class IesamApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@IesamApp)
            //modules()
        }
    }
    
}