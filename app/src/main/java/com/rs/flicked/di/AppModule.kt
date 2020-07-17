package com.rs.flicked.di

import com.rs.home.di.HomeNetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(
    includes = [
        HomeNetworkModule::class
    ]
)
object AppModule
