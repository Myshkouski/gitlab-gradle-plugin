allprojects {
    val isJitpack: Boolean = true == System.getenv("JITPACK")?.toBooleanStrictOrNull()

    group = when {
        isJitpack -> System.getenv("GROUP").takeUnlessNullOrBlank()
        else -> "io.github.myshkouski.gradle-conventions"
    }

    version = when {
        isJitpack -> System.getenv("VERSION").takeUnlessNullOrBlank()
        else -> "1.0.0-SNAPSHOT"
    }
}

private fun String?.takeUnlessNullOrBlank(): String {
    return takeUnless { it.isNullOrBlank() }!!
}
