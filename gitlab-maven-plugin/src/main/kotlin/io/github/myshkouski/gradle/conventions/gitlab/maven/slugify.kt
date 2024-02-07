package io.github.myshkouski.gradle.conventions.gitlab.maven

import java.text.Normalizer

internal fun String.toSlug(replacement: Char = '-'): String {
    return Normalizer
        .normalize(this, Normalizer.Form.NFD)
        .replace("[^\\p{ASCII}]".toRegex(), replacement.toString())
        .replace("[^a-zA-Z0-9]+".toRegex(), replacement.toString()).trim()
        .replace("\\s+".toRegex(), replacement.toString())
        .lowercase()
}

internal fun String.toSnakeCase(delimiter: Char = '-'): String {
    val pattern = "$delimiter[a-zA-Z0-9]".toRegex()
    return toSlug().replace(pattern) { it.value.last().uppercase() }
}
