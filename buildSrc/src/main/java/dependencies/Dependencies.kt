package dependencies

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersion.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersion.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${BuildDependenciesVersion.MATERIAL}"
    const val PREFERENCES =
        "androidx.preference:preference-ktx:${BuildDependenciesVersion.PREFERENCE}"
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersion.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersion.COROUTINES}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersion.CONSTRAINT_LAYOUT}"
    const val CRASHLYTICS =
        "com.google.firebase:firebase-crashlytics:${BuildDependenciesVersion.CRASHLYTICS}"
    const val FIREBASE_ANALYTICS =
        "com.google.firebase:firebase-analytics-ktx:${BuildDependenciesVersion.FIREBASE}"
    const val DAGGER_HILT = "com.google.dagger:hilt-android:${BuildDependenciesVersion.HILT}"
    const val HILT_VIEWMODEL =
        "androidx.hilt:hilt-lifecycle-viewmodel:${BuildDependenciesVersion.HILT_COMPILER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersion.RETROFIT}"
    const val OKHTTP3_LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersion.OKHTTP3_LOGGING}"
    const val MOSHI_CONVERTOR =
        "com.squareup.retrofit2:converter-moshi:${BuildDependenciesVersion.MOSHI_CONVERTOR}"
    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersion.LIFECYCLE_VIEWMODEL}"
    const val FRAGMENT_KTX =
        "androidx.fragment:fragment-ktx:${BuildDependenciesVersion.FRAGMENT_KTX}"
    const val ACTIVITY_KTX =
        "androidx.activity:activity-ktx:${BuildDependenciesVersion.ACTIVITY_KTX}"

    const val ANNOTATIONS =
        "com.android.support:support-annotations:${BuildDependenciesVersion.ANNOTATIONS}"

    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersion.TIMBER}"
}