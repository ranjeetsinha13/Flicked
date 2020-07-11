repositories {
    jcenter()
    google()
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}

object PluginsVersions {
    const val GRADLE_ANDROID = "3.5.3"
    const val KOTLIN = "1.3.61"
    const val GRADLE_CRASHLYTICS = "2.2.0"
    const val GOOGLE_SERVICES = "4.3.3"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
    implementation("com.google.gms:google-services:${PluginsVersions.GOOGLE_SERVICES}")
    implementation("com.google.firebase:firebase-crashlytics-gradle:${PluginsVersions.GRADLE_CRASHLYTICS}")
}