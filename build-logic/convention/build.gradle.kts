plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("io.github.lexadiky.openmind.bl.convention.compose-library") {
            id = name
            implementationClass = "io.github.lexadiky.openmind.bl.convention.ComposeLibraryPlugin"
        }
        create("io.github.lexadiky.openmind.bl.convention.compose-target") {
            id = name
            implementationClass = "io.github.lexadiky.openmind.bl.convention.ComposeTargetPlugin"
        }
    }
}

dependencies {
    implementation(libs.android.agp.application)
    implementation(libs.kotlin.plugin.android)
}
