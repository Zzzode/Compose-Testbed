pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Testbed"
include(":shared")
include(":compiler-hosted")
include(":runtime")
