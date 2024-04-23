enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "open-mind"

includeBuild("build-logic")
includeRecursive("./source")

fun includeRecursive(path: String) {
    val dir = file(path)
    dir.walkTopDown().maxDepth(Settings.MODULE_DISCOVERY_DEPTH).forEach { subDir ->
        if (isModule(subDir)) {
            val moduleName = createModuleName(subDir, dir)

            include(moduleName)
            project(moduleName).projectDir = subDir
        }
    }
}

fun isModule(dir: File): Boolean {
    return File(dir, "build.gradle.kts").exists() || File(dir, "build.gradle.kts.kts").exists()
}

fun createModuleName(subDir: File, dir: File): String {
    var moduleName = ":${subDir.name}"
    var currentDir = subDir.parentFile

    while (currentDir != null) {
        moduleName = ":${currentDir.name}" + moduleName

        currentDir = if (currentDir == dir) {
            null
        } else {
            currentDir.parentFile
        }
    }
    return moduleName.removePrefix(":source")
}

object Settings {
    const val MODULE_DISCOVERY_DEPTH = 3
}
