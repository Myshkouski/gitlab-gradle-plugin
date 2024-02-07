package io.github.myshkouski.plugin.test

import io.github.myshkouski.plugin.gitlab.maven.toSlug
import io.github.myshkouski.plugin.gitlab.maven.toSnakeCase
import kotlin.test.Test
import kotlin.test.assertEquals

class TextConversionTests {
    @Test
    fun toSlug() {
        val expected = "gitlab-com"
        val actual = "gitlab.com".toSlug()
        assertEquals(expected, actual)
    }

    @Test
    fun toSnakeCase() {
        val expected = "gitlabCom"
        val actual = "gitlab.com".toSnakeCase()
        assertEquals(expected, actual)
    }
}
