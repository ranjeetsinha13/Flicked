import Build_gradle.PluginsVersions.GOOGLE_SERVICES
import Build_gradle.PluginsVersions.GRADLE_ANDROID
import Build_gradle.PluginsVersions.GRADLE_CRASHLYTICS
import Build_gradle.PluginsVersions.HILT
import Build_gradle.PluginsVersions.JACOCO
import Build_gradle.PluginsVersions.KOTLIN

repositories {
    jcenter()
    google()
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}

object PluginsVersions {
    const val GRADLE_ANDROID = "3.6.3"
    const val KOTLIN = "1.3.72"
    const val GRADLE_CRASHLYTICS = "2.2.0"
    const val GOOGLE_SERVICES = "4.3.3"
    const val JACOCO = "0.8.5"
    const val HILT = "2.28-alpha"
}


dependencies {
    implementation("com.android.tools.build:gradle:$GRADLE_ANDROID")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN")
    implementation("com.google.gms:google-services:$GOOGLE_SERVICES")
    implementation("com.google.firebase:firebase-crashlytics-gradle:$GRADLE_CRASHLYTICS")
    implementation("org.jacoco:org.jacoco.core:$JACOCO")
    implementation("com.google.dagger:hilt-android-gradle-plugin:$HILT")
}