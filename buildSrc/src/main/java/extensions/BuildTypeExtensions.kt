package extensions

import com.android.build.gradle.internal.dsl.BuildType

fun BuildType.buildConfigBooleanField(name: String, value: Boolean) {
    this.buildConfigField("boolean", name, value.toString())
}