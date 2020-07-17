package com.rs.core.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import com.rs.core.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Named

class FlickedPreferencesImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @Named("app-shared-prefs") private val sharedPreferences: SharedPreferences
) : FlickedPreferences {

    private val preferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            when (key) {
                context.getString(R.string.pref_theme_key) -> updateTheme()
            }
        }

    override fun init() {
        updateTheme()
        sharedPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener)
    }

    val FlickedPreferences.Theme.value: String
        get() = when (this) {
            FlickedPreferences.Theme.LIGHT -> context.getString(R.string.pref_theme_light)
            FlickedPreferences.Theme.DARK -> context.getString(R.string.pref_theme_dark)
            FlickedPreferences.Theme.SYSTEM -> context.getString(R.string.pref_theme_system)
            FlickedPreferences.Theme.AUTO_BATTERY -> context.getString(
                R.string.pref_theme_auto_battery
            )
        }
    override var themePreference: FlickedPreferences.Theme
        get() = getThemeFromPreferenceValue(
            sharedPreferences.getString(
                context.getString(R.string.pref_theme_key),
                context.getString(R.string.pref_theme_system)
            ) ?: context.getString(R.string.pref_theme_system)
        )
        set(value) = sharedPreferences.edit {
            putString(context.getString(R.string.pref_theme_key), value.value)
        }

    private fun getThemeFromPreferenceValue(value: String) = when (value) {
        context.getString(R.string.pref_theme_light) -> FlickedPreferences.Theme.LIGHT
        context.getString(R.string.pref_theme_dark) -> FlickedPreferences.Theme.DARK
        context.getString(R.string.pref_theme_system) -> FlickedPreferences.Theme.SYSTEM
        context.getString(R.string.pref_theme_auto_battery) -> FlickedPreferences.Theme.AUTO_BATTERY
        else -> FlickedPreferences.Theme.SYSTEM
    }

    private fun updateTheme() =
        when (themePreference) {
            FlickedPreferences.Theme.LIGHT -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO
            )
            FlickedPreferences.Theme.DARK -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES
            )
            FlickedPreferences.Theme.AUTO_BATTERY -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            )
            FlickedPreferences.Theme.SYSTEM -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            )
        }
}
