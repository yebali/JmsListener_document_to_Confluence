import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

group = "com.yebali"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JMS Listener
    implementation("org.springframework:spring-jms:5.2.9.RELEASE")
    implementation("jakarta.jms:jakarta.jms-api:2.0.3")
    implementation("net.oneandone.reflections8:reflections8:0.11.7")

    // Http Request
    implementation("com.mashape.unirest:unirest-java:1.4.9")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
