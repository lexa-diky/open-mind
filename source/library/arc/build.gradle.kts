plugins {
    id("io.github.lexadiky.openmind.bl.convention.compose-library")
}

dependencies {
    implementation(libs.kotlin.coroutines)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
}