package io.github.lexadiky.openmind.bl.convention

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.ProductFlavor
import com.android.build.api.dsl.TestExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.plugins.ExtensionContainer

typealias AnyAndroidExtension = CommonExtension<
        out BuildFeatures,
        out BuildType,
        out DefaultConfig,
        out ProductFlavor,
        out AndroidResources,
        out Installation
        >


val ExtensionContainer.android: CommonExtension<out BuildFeatures, out BuildType, out DefaultConfig, out ProductFlavor, out AndroidResources, out Installation>
    get() = findByType(LibraryExtension::class.java)
        ?: findByType(BaseAppModuleExtension::class.java)
        ?: findByType(TestExtension::class.java)
        ?: error("no known android extensions registered")