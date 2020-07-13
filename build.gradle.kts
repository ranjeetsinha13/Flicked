import extensions.applyDefault

plugins.apply(BuildPlugins.GIT_HOOKS)

allprojects {
    repositories.applyDefault()
    plugins.apply(BuildPlugins.KTLINT)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
