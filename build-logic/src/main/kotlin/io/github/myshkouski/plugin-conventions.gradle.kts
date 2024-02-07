package io.github.myshkouski

plugins {
    id("org.gradle.kotlin.kotlin-dsl")
    id("com.gradle.plugin-publish")
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit test framework for unit tests
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(8)
}

java {
    withSourcesJar()
    withJavadocJar()
}

@Suppress("UnstableApiUsage")
gradlePlugin {
    website.set("https://github.com/Myshkouski/gradle-conventions")
    vcsUrl.set("https://github.com/Myshkouski/gradle-conventions.git")
}
