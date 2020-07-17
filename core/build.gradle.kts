import dependencies.Dependencies.ANNOTATIONS
import dependencies.Dependencies.COROUTINES
import dependencies.Dependencies.COROUTINES_ANDROID
import dependencies.Dependencies.MOSHI_CONVERTOR
import dependencies.Dependencies.OKHTTP3_LOGGING
import dependencies.Dependencies.PREFERENCES
import dependencies.Dependencies.RETROFIT
import dependencies.Dependencies.TIMBER
import extensions.buildConfigStringField
import utils.getLocalProperty

plugins {
    id("library.android-library")
}

android {
    buildTypes.forEach {
        it.buildConfigStringField("TMDB_API_KEY", getLocalProperty("tmdb_api_key"))
        it.buildConfigStringField("TMDB_BASE_URL", "https://api.themoviedb.org/")
    }
}

dependencies {
    implementation(OKHTTP3_LOGGING)
    implementation(RETROFIT)
    implementation(PREFERENCES)
    implementation(ANNOTATIONS)
    implementation(COROUTINES)
    implementation(COROUTINES_ANDROID)
    implementation(MOSHI_CONVERTOR)
    implementation(TIMBER)
}
