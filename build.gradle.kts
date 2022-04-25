val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version = "3.0.1"

plugins {
    application
    kotlin("jvm") version "1.6.21"
                id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
}

group = "com.drake1804"
version = "0.0.1"
application {
    mainClass.set("com.drake1804.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.github.pdvrieze.xmlutil:ktor:0.84.0")
    implementation("org.simpleframework:simple-xml:2.7.1")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}