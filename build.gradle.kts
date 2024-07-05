plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}