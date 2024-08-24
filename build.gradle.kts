plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

group = "essentials"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

private val assertjVersion = "3.26.3"
private val junitVersion = "5.11.0"

dependencies {
    testImplementation(kotlin("test"))

    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

ktlint {
    version.set("1.3.1")
}
