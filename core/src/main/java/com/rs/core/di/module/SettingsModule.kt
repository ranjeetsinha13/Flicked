package com.rs.core.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.rs.core.settings.FlickedPreferences
import com.rs.core.settings.FlickedPreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
internal abstract class SettingsModuleBinds {
    @Singleton
    @Binds
    abstract fun bindPreferences(bind: FlickedPreferencesImpl): FlickedPreferences
}

@InstallIn(ApplicationComponent::class)
@Module
internal object SettingsModule {
    @Named("app-shared-prefs")
    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
}
