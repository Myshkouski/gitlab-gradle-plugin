package io.github.myshkouski.gradle.conventions

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.conventions(name: String, version: String): String {
    val group: String by projectProperties

    require(group.isNotBlank())
    require(name.isNotBlank())
    require(version.isNotBlank())

    return "$group:$name-plugin:$version"
}

fun DependencyHandler.conventions(name: String): String {
    val version: String by projectProperties
    return conventions(name, version)
}
