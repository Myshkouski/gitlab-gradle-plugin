import io.github.myshkouski.configurePluginId

plugins {
    id("io.github.myshkouski.plugin-conventions")
}

@Suppress("UnstableApiUsage")
gradlePlugin {
    plugins.create("sonatype") {
        configurePluginId(name)
        implementationClass = "io.github.myshkouski.plugin.sonatype.SonatypePlugin"
        displayName = "Plugin for using Sonatype repository"
        description = "A plugin that helps you using Gitlab Maven repository for dependency resolution and publishing."
        tags = listOf("maven", "gitlab", "dependencies", "publishing")
    }
}
