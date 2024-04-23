package io.github.lexadiky.openmind.bl.convention.mixin

import io.github.lexadiky.openmind.bl.convention.android
import org.gradle.api.JavaVersion
import org.gradle.api.Project

object GenericAndroidMixin {

    fun apply(target: Project) {
        target.extensions.android.apply {
            namespace = "io.github.lexadiky.openmind"
            compileSdk = 34

            defaultConfig {
                minSdk = 24

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.1"
            }
            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }
        }
    }
}