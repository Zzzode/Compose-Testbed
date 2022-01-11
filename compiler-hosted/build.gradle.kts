plugins {
    kotlin("jvm")
}

sourceSets {
    main {
        java.srcDir("compose-mm/support/compose/compiler/compiler-hosted/src/main/java")
        resources.srcDir("compose-mm/support/compose/compiler/compiler-hosted/src/main/resources")
    }
}

dependencies {
    compileOnly(Dependencies.stdlib)
    compileOnly(Dependencies.kotlinCompiler)
}