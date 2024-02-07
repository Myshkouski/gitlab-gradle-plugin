package io.github.myshkouski.gradle.conventions.sonatype

import org.gradle.api.Project

fun Project.isSnapshotVersion(): Boolean {
    val version = this.version.toString()
    require(version.isNotEmpty())
    return version.endsWith("SNAPSHOT")
}
