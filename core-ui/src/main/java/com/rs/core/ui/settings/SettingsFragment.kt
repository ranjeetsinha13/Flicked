package com.rs.core.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.rs.core.ui.R

class SettingsFragment : PreferenceFragmentCompat() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}
