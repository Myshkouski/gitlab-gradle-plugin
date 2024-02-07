package io.github.myshkouski.gradle.conventions

import java.util.*

private fun loadProjectProperties(): Properties {
    val propertiesFile = ConventionsPlugin::class.java.getResourceAsStream("/project.properties")
    val properties = Properties()
    properties.load(propertiesFile)
    return properties
}

internal val projectProperties: Properties by lazy {
    loadProjectProperties()
}
