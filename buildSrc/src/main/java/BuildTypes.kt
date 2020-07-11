interface BuildType {

    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    val isMinifyEnabled: Boolean
    val isCrashlyticsEnabled: Boolean
    val isTestCoverageEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isCrashlyticsEnabled = false
    override val isTestCoverageEnabled = true

    const val applicationIdSuffix = ".debug"
    const val versionNameSuffix = "-DEBUG"
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val isCrashlyticsEnabled = true
    override val isTestCoverageEnabled = true
}