package com.rs.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rs.core.network.response.Resource
import com.rs.core.ui.base.BaseActivity
import com.rs.core.ui.settings.SettingsActivity
import com.rs.home.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity : BaseActivity(R.layout.activity_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.movies.observe(
            this,
            Observer {
                when (it) {
                    is Resource.Loading -> {
                        Timber.d("loadinng")
                    }
                    is Resource.Success -> {
                        Timber.d("${it.data}")
                    }

                    is Resource.Error -> {
                        Timber.d("${it.message}")
                    }
                }
            }

        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_main_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
