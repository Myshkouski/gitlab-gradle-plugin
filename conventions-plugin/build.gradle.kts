import io.github.myshkouski.pluginScope
import java.util.Properties

plugins {
    id("io.github.myshkouski.plugin-conventions")
}

// @Suppress("UnstableApiUsage")
gradlePlugin {
    plugins.create("conventions") {
        id = "io.github.myshkouski.conventions"
        implementationClass = "io.github.myshkouski.gradle.conventions.ConventionsPlugin"
        // displayName = "Plugin for using Gitlab Maven repository"
        // description = "A plugin that helps you using Gitlab Maven repository for dependency resolution and publishing."
        // tags = listOf("maven", "gitlab", "dependencies", "publishing")
    }
}

tasks.create<Task>("projectPropertiesResourceFile") {
    group = "build"

    doLast {
        val properties = Properties().apply {
            setProperty("group", project.group.toString())
            setProperty("version", project.version.toString())
            setProperty("pluginScope", pluginScope)
        }

        val file: File = project.layout.buildDirectory.file("resources/main/project.properties").get().asFile
        file.parentFile.mkdirs()
        file.createNewFile()

        properties.store(file.outputStream(), null)
    }
}

tasks.classes {
    dependsOn(tasks.named("projectPropertiesResourceFile"))
}
