package com.rs.home.network.services

import com.rs.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class TMDBRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        val requestBuilder = chain.request().newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
