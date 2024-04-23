package io.github.lexadiky.openmind.bl.convention

import com.android.build.api.dsl.ApplicationExtension
import io.github.lexadiky.openmind.bl.convention.mixin.GenericAndroidMixin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ComposeTargetPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("com.android.application")
        target.plugins.apply("org.jetbrains.kotlin.android")
        target.plugins.apply("com.google.devtools.ksp")
        GenericAndroidMixin.apply(target)

        target.extensions.configure<ApplicationExtension> {
            defaultConfig {
                applicationId = "io.github.lexadiky.openmind"
                versionCode = 1
                versionName = "1.0"
            }
        }
    }
}