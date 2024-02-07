enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
}

rootProject.name = "gradle-conventions"

include("conventions-plugin")
include("gitlab-maven-plugin")
include("sonatype-plugin")
