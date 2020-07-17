import dependencies.Dependencies.ACTIVITY_KTX
import dependencies.Dependencies.APPCOMPAT
import dependencies.Dependencies.CONSTRAINT_LAYOUT
import dependencies.Dependencies.FRAGMENT_KTX
import dependencies.Dependencies.MATERIAL
import dependencies.Dependencies.PREFERENCES

plugins {
    id("library.android-library")
    id("kotlin-android")
}
dependencies {
    implementation(project(BuildModules.CORE))
    implementation(MATERIAL)
    implementation(PREFERENCES)
    implementation(FRAGMENT_KTX)
    implementation(APPCOMPAT)
    implementation(ACTIVITY_KTX)
    implementation(CONSTRAINT_LAYOUT)
}
