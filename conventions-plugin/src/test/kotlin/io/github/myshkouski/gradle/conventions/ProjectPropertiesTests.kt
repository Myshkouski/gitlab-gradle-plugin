package io.github.myshkouski.gradle.conventions

import io.github.myshkouski.gradle.conventions.projectProperties
import kotlin.test.Test
import kotlin.test.assertFalse

class ProjectPropertiesTests {
    @Test
    fun `group is not empty`() {
        val group: String? by projectProperties
        assertFalse(group.isNullOrBlank())
    }

    @Test
    fun `version is not empty`() {
        val version: String? by projectProperties
        assertFalse(version.isNullOrBlank())
    }
}