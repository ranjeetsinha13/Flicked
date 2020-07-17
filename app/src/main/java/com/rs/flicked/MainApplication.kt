package com.rs.flicked

import android.app.Application
import com.rs.core.settings.FlickedPreferences
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {
    @Inject
    lateinit var settingsPrefs: FlickedPreferences

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        settingsPrefs.init()
    }
}
