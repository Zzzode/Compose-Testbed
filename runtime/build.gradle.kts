plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

val runtimeDir = "runtime/runtime/src"

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
    )

    sourceSets {
        val commonMain by getting {
            kotlin.srcDirs(JetpackSourceSets.commonSrcByPath(runtimeDir))
            dependencies {
                implementation(Dependencies.stdlibCommon)
                implementation(Dependencies.kotlinxCoroutinesCore)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
    }
}

dependencies {
    add(
        org.jetbrains.kotlin.gradle.plugin.NATIVE_COMPILER_PLUGIN_CLASSPATH_CONFIGURATION_NAME,
        project(":compiler-hosted")
    )
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile(JetpackSourceSets.androidManifestByPath(runtimeDir))
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}