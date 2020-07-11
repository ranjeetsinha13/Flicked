package dependencies

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersion.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersion.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${BuildDependenciesVersion.MATERIAL}"
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersion.COROUTINES}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersion.CONSTRAINT_LAYOUT}"

    const val CRASHLYTICS =
        "com.google.firebase:firebase-crashlytics:${BuildDependenciesVersion.CRASHLYTICS}"
    const val FIREBASE_ANALYTICS =
        "com.google.firebase:firebase-analytics-ktx:${BuildDependenciesVersion.FIREBASE}"
}