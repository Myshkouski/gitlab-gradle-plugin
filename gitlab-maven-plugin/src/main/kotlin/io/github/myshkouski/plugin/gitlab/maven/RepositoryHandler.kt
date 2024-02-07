package io.github.myshkouski.plugin.gitlab.maven

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
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    val url = gitlabProjectUrl(projectId, host)
    val name = host.toSnakeCase() + "Project$projectId"
    return gitlab(name, url, action)
}

fun RepositoryHandler.gitlabProject(
    projectId: Int?,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository? {
    projectId ?: return null
    return gitlabProject(projectId, host, action)
}

fun RepositoryHandler.gitlabProject(
    projectId: String?,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository? {
    return gitlabProject(projectId?.toInt(), host, action)
}

fun RepositoryHandler.gitlabProject(
    vararg projectIds: Int,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : Set<MavenArtifactRepository> {
    return projectIds.map {
        gitlabProject(it, host, action)
    }.toSet()
}

fun RepositoryHandler.gitlabGroup(
    groupId: Int,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository {
    val url = gitlabGroupUrl(groupId, host)
    val name = url.host.toSnakeCase() + "Group$groupId"
    return gitlab(name, url, action)
}

fun RepositoryHandler.gitlabGroup(
    groupId: Int?,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : MavenArtifactRepository? {
    groupId ?: return null
    return gitlabGroup(groupId, host, action)
}

fun RepositoryHandler.gitlabGroup(
    vararg groupIds: Int,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : Set<MavenArtifactRepository> {
    return groupIds.map {
        gitlabGroup(it, host, action)
    }.toSet()
}

fun RepositoryHandler.gitlabGroup(
    vararg groupIds: String?,
    host: String = GITLAB_COM_HOST,
    action: MavenArtifactRepository.() -> Unit = {}
) : Set<MavenArtifactRepository> {
    return groupIds.mapNotNull {
        gitlabGroup(it?.toInt(), host, action)
    }.toSet()
}
