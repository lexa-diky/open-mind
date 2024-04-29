plugins {
    id("io.github.lexadiky.openmind.bl.convention.compose-target")
}

dependencies {
    implementation(projects.feature.settings)
    implementation(projects.feature.bottomNavigationBar)
    implementation(projects.feature.calendar)
    implementation(projects.feature.analyze)
    implementation(projects.feature.me)

    implementation(projects.library.navigation)
    implementation(projects.library.uikit)
    implementation(projects.library.arc)

    implementation(libs.kotlin.serialization)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.autoservice.annotations)
    ksp(libs.autoservice.ksp)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}