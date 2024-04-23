package io.github.lexadiky.openmind.bl.convention

import com.android.build.api.dsl.LibraryExtension
import io.github.lexadiky.openmind.bl.convention.mixin.GenericAndroidMixin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.model.KotlinAndroidExtension

class ComposeLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("com.android.library")
        target.plugins.apply("org.jetbrains.kotlin.android")
        GenericAndroidMixin.apply(target)
    }
}