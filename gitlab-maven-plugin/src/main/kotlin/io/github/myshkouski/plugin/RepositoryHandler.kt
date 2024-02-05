package io.github.myshkouski.plugin

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import java.net.URI

private fun RepositoryHandler.gitlab(
    name: String,
    uri: URI,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    return maven {
        this.name = name
        url = uri
        action()
    }
}

fun RepositoryHandler.gitlabInstance(
    host: String,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    return gitlab(host.toSnakeCase(), gitlabInstanceUrl(host), action)
}

fun RepositoryHandler.gitlabInstance(
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    return gitlabInstance(GITLAB_COM_HOST, action)
}

fun RepositoryHandler.gitlabProject(
    projectId: Int,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    val url = gitlabProjectUrl(projectId)
    val name = url.host.toSnakeCase() + "Project$projectId"
    return gitlab(name, url, action)
}

fun RepositoryHandler.gitlabProject(
    projectId: Int?,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository? {
    projectId ?: return null

    return gitlabProject(projectId, action)
}

fun RepositoryHandler.gitlabProject(
    vararg projectIds: Int,
    action: MavenArtifactRepository.() -> Unit = {}
) : Set<MavenArtifactRepository> {
    return projectIds.map {
        gitlabProject(it, action)
    }.toSet()
}

fun RepositoryHandler.gitlabGroup(
    groupId: Int,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    val url = gitlabGroupUrl(groupId)
    val name = url.host.toSnakeCase() + "Group$groupId"
    return gitlab(name, url, action)
}

fun RepositoryHandler.gitlabGroup(
    groupId: Int?,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository? {
    groupId ?: return null
    return gitlabGroup(groupId, action)
}

fun RepositoryHandler.gitlabGroup(
    vararg groupIds: Int,
    action: MavenArtifactRepository.() -> Unit = {}
) : Set<MavenArtifactRepository> {
    return groupIds.map {
        gitlabGroup(it, action)
    }.toSet()
}
