package io.github.myshkouski

import org.gradle.plugin.devel.PluginDeclaration

fun PluginDeclaration.configurePluginId(name: String) {
    id = "$PLUGIN_GROUP.$name"
}

private const val PLUGIN_GROUP = "io.github.myshkouski.conventions"
