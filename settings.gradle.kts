rootProject.name = "Flicked"
include(
        ":app",
        ":core",
        ":core-ui",
        ":features:home",
        ":features:account:social"
)
rootProject.buildFileName = "build.gradle.kts"
include(":features:account")
