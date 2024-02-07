plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation("com.gradle.publish:plugin-publish-plugin:1.2.1")
    implementation("org.gradle.kotlin:gradle-kotlin-dsl-plugins:4.2.1")
}
