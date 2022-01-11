pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Testbed"
include(":androidApp")
include(":shared")
include(":compiler-hosted")
include(":runtime")
include(":compose-mm")
