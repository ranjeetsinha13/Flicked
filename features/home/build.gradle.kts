import dependencies.Dependencies.ACTIVITY_KTX
import dependencies.Dependencies.APPCOMPAT
import dependencies.Dependencies.CONSTRAINT_LAYOUT
import dependencies.Dependencies.FRAGMENT_KTX
import dependencies.Dependencies.HILT_VIEWMODEL
import dependencies.Dependencies.LIFECYCLE_VIEWMODEL
import dependencies.Dependencies.MATERIAL
import dependencies.Dependencies.MOSHI_CONVERTOR
import dependencies.Dependencies.OKHTTP3_LOGGING
import dependencies.Dependencies.PREFERENCES
import dependencies.Dependencies.RETROFIT
import dependencies.Dependencies.TIMBER

plugins {
    id("library.android-library")
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.CORE_UI))
    implementation(RETROFIT)
    implementation(MOSHI_CONVERTOR)
    implementation(OKHTTP3_LOGGING)
    implementation(APPCOMPAT)
    implementation(MATERIAL)
    implementation(PREFERENCES)
    implementation(CONSTRAINT_LAYOUT)
    implementation(HILT_VIEWMODEL)
    implementation(LIFECYCLE_VIEWMODEL)
    implementation(FRAGMENT_KTX)
    implementation(ACTIVITY_KTX)
    implementation(TIMBER)
}