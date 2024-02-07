import io.github.myshkouski.configurePluginId

plugins {
    id("io.github.myshkouski.plugin-conventions")
}

@Suppress("UnstableApiUsage")
gradlePlugin {
    plugins.create("gitlabMaven") {
        configurePluginId("gitlab-maven")
        implementationClass = "io.github.myshkouski.gradle.conventions.gitlab.maven.GitlabMavenPlugin"
        displayName = "Plugin for using Gitlab Maven repository"
        description = "A plugin that helps you using Gitlab Maven repository for dependency resolution and publishing."
        tags = listOf("maven", "gitlab", "dependencies", "publishing")
    }
}
