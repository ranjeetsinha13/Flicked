package com.rs.core.ui.settings

import androidx.annotation.StringRes
import com.rs.core.ui.R
import com.rs.core.ui.base.BaseActivity
import com.rs.core.ui.extensions.replace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : BaseActivity(R.layout.activity_settings) {
    @StringRes
    override val toolBarTitle: Int = R.string.settings_activity_title

    override val shouldShowBackButton = true

    override fun initialize() {
        this.replace(android.R.id.content, SettingsFragment.newInstance())
    }
}
