plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.1"
}

repositories {
    // Use Maven Central for resolving dependencies
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

group = "io.github.myshkouski"
version = "0.0.1"

gradlePlugin {
    plugins.create("gitlabMaven") {
        id = "${project.group}.gitlab-maven"
        implementationClass = "io.github.myshkouski.plugin.GitlabMavenPlugin"
        website.set("https://github.com/Myshkouski/gitlab-gradle-plugin")
        vcsUrl.set("https://github.com/Myshkouski/gitlab-gradle-plugin.git")
        displayName = "Plugin for using Gitlab Maven repository"
        description = "A plugin that helps you using Gitlab Maven repository for dependency resolution and publishing."
        tags = listOf("maven", "gitlab", "dependencies", "publishing")
    }
    // plugins.create("sonatype") {
    //     id = "${project.group}.sonatype"
    //     implementationClass = "io.github.myshkouski.plugin.SonatypePlugin"
    // }
}
