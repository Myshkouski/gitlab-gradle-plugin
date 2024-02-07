package io.github.myshkouski

import org.gradle.plugin.devel.PluginDeclaration

fun PluginDeclaration.configurePluginId(name: String) {
    id = "$pluginScope.$name"
}
