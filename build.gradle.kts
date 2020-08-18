import extensions.applyDefault

plugins.apply(BuildPlugins.GIT_HOOKS)

allprojects {
    repositories.applyDefault()
    plugins.apply(BuildPlugins.KTLINT)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
buildscript {
    repositories {
        jcenter()
    }
    val kotlin_version by extra("1.4.0")
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}
