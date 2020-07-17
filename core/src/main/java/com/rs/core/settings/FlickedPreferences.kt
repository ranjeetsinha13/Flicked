package com.rs.core.settings

interface FlickedPreferences {

    fun init()

    var themePreference: Theme

    enum class Theme {
        LIGHT,
        DARK,
        SYSTEM,
        AUTO_BATTERY
    }
}
