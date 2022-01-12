plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

version = "0.0.1"

val runtimeDir = "runtime/runtime/src"

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        // iosSimulatorArm64() sure all ios dependencies support this target
    )

    sourceSets {
        val commonMain by getting {
            kotlin.srcDirs(JetpackSourceSets.commonSrcByPath(runtimeDir))
            dependencies {
                implementation(Dependencies.stdlibCommon)
                implementation(Dependencies.kotlinxCoroutinesCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            kotlin.srcDirs(
                JetpackSourceSets.androidSrcByPath(runtimeDir),
                JetpackSourceSets.jvmSrcByPath(runtimeDir),
            )
            dependencies {
                api(Dependencies.kotlinxCoroutinesAndroid)
                api(Dependencies.androidxAnnotation)
                api(Dependencies.kotlinxCoroutinesCore)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        // val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            // iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        // val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            // iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

dependencies {
    add(
        org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME,
        project(":compiler-hosted")
    )
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