plugins {
    id("io.github.lexadiky.openmind.bl.convention.compose-library")
}

dependencies {
    implementation(projects.library.navigation)
    implementation(projects.library.uikit)

    compileOnly(libs.autoservice.annotations)
    ksp(libs.autoservice.ksp)

    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}