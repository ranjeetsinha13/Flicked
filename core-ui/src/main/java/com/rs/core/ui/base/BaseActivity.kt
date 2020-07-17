package com.rs.core.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.rs.core.ui.R

abstract class BaseActivity(
    @LayoutRes private val resID: Int
) : AppCompatActivity() {

    @StringRes
    protected open val toolBarTitle: Int = R.string.app_name

    protected open val shouldShowBackButton = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resID)
        initialize()
        setupToolBar()
    }

    protected open fun initialize() {
        // Do Nothing
    }

    private fun setupToolBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(shouldShowBackButton)
            title = getString(toolBarTitle)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
