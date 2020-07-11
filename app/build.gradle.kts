import BuildAndroidConfig.APPLICATION_ID
import BuildAndroidConfig.BUILD_TOOLS_VERSION
import BuildAndroidConfig.COMPILE_SDK_VERSION
import BuildAndroidConfig.MIN_SDK_VERSION
import BuildAndroidConfig.TARGET_SDK_VERSION
import BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
import BuildAndroidConfig.VERSION_CODE
import BuildAndroidConfig.VERSION_NAME
import BuildType.Companion.DEBUG
import BuildType.Companion.RELEASE
import dependencies.AnnotationProcessorDependencies.DATABINDING
import dependencies.Dependencies.APPCOMPAT
import dependencies.Dependencies.CONSTRAINT_LAYOUT
import dependencies.Dependencies.COROUTINES
import dependencies.Dependencies.CRASHLYTICS
import dependencies.Dependencies.FIREBASE_ANALYTICS
import dependencies.Dependencies.KOTLIN
import dependencies.Dependencies.MATERIAL
import extensions.addTestsDependencies
import extensions.buildConfigBooleanField

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.GOOGLE_SERVICES)
    id(BuildPlugins.CRASHLYTICS)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdkVersion(COMPILE_SDK_VERSION)
    buildToolsVersion(BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = APPLICATION_ID
        minSdkVersion(MIN_SDK_VERSION)
        targetSdkVersion(TARGET_SDK_VERSION)
        versionCode = VERSION_CODE
        versionName = VERSION_NAME

        testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
            buildConfigBooleanField("ENABLE_CRASHLYTICS", BuildTypeRelease.isCrashlyticsEnabled)
        }
        getByName(DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled

            buildConfigBooleanField("ENABLE_CRASHLYTICS", BuildTypeDebug.isCrashlyticsEnabled)
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
    implementation(KOTLIN)
    implementation(APPCOMPAT)
    implementation(MATERIAL)
    implementation(COROUTINES)
    implementation(CONSTRAINT_LAYOUT)

    implementation(FIREBASE_ANALYTICS)
    implementation(CRASHLYTICS)

    // TODO This should be moved to ui module
    kapt(DATABINDING)

    addTestsDependencies()
}
