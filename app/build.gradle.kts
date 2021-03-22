import gradle.*

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Versions.AndroidConfig.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.AndroidConfig.minSdk)
        targetSdkVersion(Versions.AndroidConfig.targetSdk)
        applicationId = Versions.AndroidConfig.applicationId
        versionCode = Versions.AndroidConfig.versionCode
        versionName = Versions.AndroidConfig.versionName

        testInstrumentationRunner = Versions.AndroidConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName(Versions.AndroidConfig.buildEnvironment) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Versions.AndroidConfig.proguardConfigFile),
                Versions.AndroidConfig.proguardRules
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/AL2.0")
        exclude("META-INF/*.kotlin_module")
    }
    configurations {
        "implementation" {
            resolutionStrategy {
                exclude(
                    group = "org.jetbrains.kotlinx",
                    module = "kotlinx-coroutines-debug"
                )
            }
        }
    }
}

dependencies {
    //Kotlin
    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Kotlin.reflect)

    //Android
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.ktx)

    //Compose
    implementation(Dependencies.AndroidX.composeUi)
    implementation(Dependencies.AndroidX.composeMaterial)
    implementation(Dependencies.AndroidX.composeConstraint)
    implementation(Dependencies.AndroidX.composeMaterialIconsCore)
    implementation(Dependencies.AndroidX.composeMaterialIconsExt)
    implementation(Dependencies.AndroidX.composeAnimation)
    implementation(Dependencies.AndroidX.composeActivity)
    implementation(Dependencies.AndroidX.composeFoundation)
    implementation(Dependencies.AndroidX.composeRuntime)
    implementation(Dependencies.AndroidX.composeRuntimeLiveData)
    implementation(Dependencies.AndroidX.composeRuntimeRxjava)
    implementation(Dependencies.AndroidX.composeTooling)
    implementation(Dependencies.AndroidX.composeNavigation)
    implementation(Dependencies.AndroidX.composeUiTesting)

    //Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitGson)

    //Glide
    implementation(Dependencies.Coil.accompanist)

    //Material Components
    implementation(Dependencies.Google.material)
}