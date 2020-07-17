package dependencies

object AnnotationProcessorDependencies {
    const val DATABINDING =
        "com.android.databinding:compiler:${BuildDependenciesVersion.DATABINDING}"
    const val HILT_KAPT = "com.google.dagger:hilt-android-compiler:${BuildDependenciesVersion.HILT}"

    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${BuildDependenciesVersion.HILT_COMPILER}"
}