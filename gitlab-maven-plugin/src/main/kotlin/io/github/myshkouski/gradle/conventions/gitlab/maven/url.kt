package io.github.myshkouski.gradle.conventions.gitlab.maven

import java.net.URI
import java.net.URL

internal const val GITLAB_COM_HOST = "gitlab.com"
private const val GITLAB_COM_INSTANCE_PATH = "/api/v4/packages/maven"

private fun gitlabUrl(host: String, path: String): URI {
    return URL("https", host, path).toURI()
}

internal fun gitlabInstanceUrl(host: String): URI {
    return gitlabUrl(host, GITLAB_COM_INSTANCE_PATH)
}

internal fun gitlabProjectUrl(projectId: Int, host: String): URI {
    return gitlabUrl(host, "/api/v4/projects/$projectId/packages/maven")
}

internal fun gitlabGroupUrl(groupId: Int, host: String): URI {
    return gitlabUrl(host, "/api/v4/groups/$groupId/-/packages/maven")
}
