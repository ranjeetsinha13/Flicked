package com.rs.home.di

import com.rs.core.BuildConfig
import com.rs.core.di.module.NetworkModule
import com.rs.home.network.services.TMDBHomeService
import com.rs.home.network.services.TMDBRequestInterceptor
import com.rs.home.repository.TmdbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(
    includes = [NetworkModule::class]
)
@InstallIn(ApplicationComponent::class)
object HomeNetworkModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.TMDB_BASE_URL

    @Provides
    fun providesHttpInterceptor(@Named("tmdb-api") tmdbApiKey: String) = Interceptor {
        val url: HttpUrl =
            it.request().url.newBuilder().addQueryParameter("api_key", tmdbApiKey).build()
        it.proceed(it.request().newBuilder().url(url).build())
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClientBuilder: OkHttpClient.Builder,
        baseUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClientBuilder.addInterceptor(TMDBRequestInterceptor()).build())
            .build()

    @Provides
    @Singleton
    fun provideTMDBHomeService(retrofit: Retrofit): TMDBHomeService =
        retrofit.create(TMDBHomeService::class.java)

    @Provides
    @Singleton
    fun provideTmdbRepository(tmdbHomeService: TMDBHomeService) = TmdbRepository(tmdbHomeService)
}
