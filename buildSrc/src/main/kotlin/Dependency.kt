object Version {
    const val kotlin = "1.5.31"

    /**
     * The "native-mt" version of kotlin coroutine can use multi-threading in kotlin-native.
     * see detail in https://kotlinlang.org/docs/kmm-concurrency-and-coroutines.html#multithreaded-coroutines.
     */
    const val kotlinxCoroutines = "1.5.2-native-mt"
}

object JetpackSourceSets {
    const val base = "../compose-mm/support"
    const val compose = "$base/compose"
    private const val commonSrc = "commonMain/kotlin"
    private const val androidSrc = "androidMain/kotlin"
    private const val jvmSrc = "jvmMain/kotlin"
    private const val manifest = "AndroidManifest.xml"

    fun androidManifestByPath(absPath: String): String {
        return "$compose/$absPath/androidMain/$manifest"
    }

    fun androidResByPath(absPath: String): String {
        return "$compose/$absPath/androidMain/res"
    }

    fun androidSrcByPath(absPath: String): String {
        return "$compose/$absPath/$androidSrc"
    }

    fun commonSrcByPath(absPath: String): String {
        return "$compose/$absPath/$commonSrc"
    }

    fun jvmSrcByPath(absPath: String): String {
        return "$compose/$absPath/$jvmSrc"
    }
}

object Dependencies {
    const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:${Version.kotlin}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val kotlinCompiler = "org.jetbrains.kotlin:kotlin-compiler:${Version.kotlin}"
    const val composeCompiler = "androidx.compose.compiler:compiler:1.1.0-beta04"
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinxCoroutines}"
    const val kotlinxCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinxCoroutines}"
    const val androidxAnnotation = "androidx.annotation:annotation:1.2.0"
}