package io.github.myshkouski.plugin.sonatype

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import java.net.URI

private fun RepositoryHandler.sonatype(uri: URI, action: MavenArtifactRepository.() -> Unit = {}): MavenArtifactRepository {
    return maven {
        name = "sonatype"
        url = uri
        action()
    }
}

fun RepositoryHandler.sonatypeRelease(action: MavenArtifactRepository.() -> Unit = {}): MavenArtifactRepository {
    return sonatype(URI("https://s01.oss.sonatype.org/content/repositories/releases/"), action)
}

fun RepositoryHandler.sonatypeSnapshot(action: MavenArtifactRepository.() -> Unit = {}): MavenArtifactRepository {
    return sonatype(URI("https://s01.oss.sonatype.org/content/repositories/snapshots/"), action)
}

    fun RepositoryHandler.sonatype(snapshot: Boolean, action: MavenArtifactRepository.() -> Unit = {}): MavenArtifactRepository {
    return if (snapshot) sonatypeSnapshot(action) else sonatypeRelease(action)
}
