plugins {
    kotlin("jvm")
}

sourceSets {
    main {
        java.srcDir("${JetpackSourceSets.compose}/compiler/compiler-hosted/src/main/java")
        resources.srcDir("${JetpackSourceSets.compose}/compiler/compiler-hosted/src/main/resources")
    }
}

dependencies {
    compileOnly(Dependencies.stdlib)
    compileOnly(Dependencies.kotlinCompiler)
}