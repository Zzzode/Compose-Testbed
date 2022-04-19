plugins {
    kotlin("multiplatform")
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
    ).forEach {
        it.binaries.framework {
            embedBitcode("disable")
            export(project(":runtime"))
            transitiveExport = true
            baseName = "shared"
            isStatic = false
        }

        it.compilations.all {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true",
                )
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":runtime"))
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
