import BuildAndroidConfig.APPLICATION_ID
import BuildAndroidConfig.COMPILE_SDK_VERSION
import BuildAndroidConfig.MIN_SDK_VERSION
import BuildAndroidConfig.TARGET_SDK_VERSION
import BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
import BuildAndroidConfig.VERSION_CODE
import BuildAndroidConfig.VERSION_NAME
import BuildDependenciesVersion.JACOCO
import BuildType.Companion.DEBUG
import BuildType.Companion.RELEASE
import dependencies.AnnotationProcessorDependencies.DATABINDING
import dependencies.AnnotationProcessorDependencies.HILT_COMPILER
import dependencies.AnnotationProcessorDependencies.HILT_KAPT
import dependencies.Dependencies.ACTIVITY_KTX
import dependencies.Dependencies.APPCOMPAT
import dependencies.Dependencies.CONSTRAINT_LAYOUT
import dependencies.Dependencies.COROUTINES
import dependencies.Dependencies.CRASHLYTICS
import dependencies.Dependencies.DAGGER_HILT
import dependencies.Dependencies.FIREBASE_ANALYTICS
import dependencies.Dependencies.FRAGMENT_KTX
import dependencies.Dependencies.HILT_VIEWMODEL
import dependencies.Dependencies.KOTLIN
import dependencies.Dependencies.LIFECYCLE_VIEWMODEL
import dependencies.Dependencies.MATERIAL
import dependencies.Dependencies.PREFERENCES
import dependencies.Dependencies.RETROFIT
import dependencies.Dependencies.TIMBER
import extensions.addTestsDependencies
import extensions.buildConfigBooleanField
import extensions.buildConfigStringField
import utils.getLocalProperty

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.GOOGLE_SERVICES)
    id(BuildPlugins.CRASHLYTICS)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.HILT)
    id(BuildPlugins.JACOCO)
    id(BuildPlugins.JACOCO_REPORT)
}

android {
    compileSdkVersion(COMPILE_SDK_VERSION)

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

    jacoco {
        buildToolsVersion(JACOCO)
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes.forEach {
        it.buildConfigStringField("TMDB_API_KEY", getLocalProperty("tmdb_api_key"))
        it.buildConfigStringField("TMDB_BASE_URL", "https://api.themoviedb.org/3/")
    }
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.CORE_UI))
    implementation(project(BuildModules.Features.HOME))
    implementation(project(BuildModules.Features.ACCOUNT))
    implementation(KOTLIN)
    implementation(APPCOMPAT)
    implementation(MATERIAL)
    implementation(PREFERENCES)
    implementation(COROUTINES)
    implementation(CONSTRAINT_LAYOUT)
    implementation(DAGGER_HILT)
    implementation(HILT_VIEWMODEL)
    implementation(RETROFIT)
    implementation(FIREBASE_ANALYTICS)
    implementation(CRASHLYTICS)

    implementation(LIFECYCLE_VIEWMODEL)
    implementation(FRAGMENT_KTX)
    implementation(ACTIVITY_KTX)
    implementation(TIMBER)

    // TODO This should be moved to ui module
    kapt(DATABINDING)

    kapt(HILT_KAPT)
    kapt(HILT_COMPILER)

    addTestsDependencies()
}
