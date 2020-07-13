package plugins

import BuildDependenciesVersion.KTLINT

val ktlint: Configuration by configurations.creating

dependencies {
    ktlint("com.pinterest:ktlint:$KTLINT")
}

tasks {
    register<JavaExec>("ktlint") {
        group = BuildTaskGroups.VERIFICATION
        description = "Check Kotlin code style."
        classpath = ktlint
        main = "com.pinterest.ktlint.Main"
        args("--android", "src/**/*.kt")
    }

    register<JavaExec>("ktlintFormat") {
        group = BuildTaskGroups.FORMATTING
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        main = "com.pinterest.ktlint.Main"
        args("--android", "-F", "src/**/*.kt")
    }
}