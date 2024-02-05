package io.github.myshkouski.plugin.test

import io.github.myshkouski.plugin.toSlug
import io.github.myshkouski.plugin.toSnakeCase
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
