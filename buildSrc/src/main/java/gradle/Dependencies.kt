package gradle

object Dependencies {

    object Kotlin {
        const val core = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.googleMaterial}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val core = "androidx.core:core:${Versions.core}"
        const val ktx = "androidx.core:core-ktx:${Versions.core}"

        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"

        // Tooling support (Previews, etc.)
        const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"

        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"

        // Material Design
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val composeConstraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"

        // Material design icons
        const val composeMaterialIconsCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
        const val composeMaterialIconsExt = "androidx.compose.material:material-icons-extended:${Versions.compose}"

        // Integration with animations
        const val composeAnimation = "androidx.compose.animation:animation:${Versions.compose}"

        // Integration with activities
        const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"

        // Integration with ViewModels
        const val composeLifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.compose}"

        // Integration with observables
        const val composeRuntimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val composeRuntimeRxjava = "androidx.compose.runtime:runtime-rxjava2:${Versions.compose}"

        //Integration with Navigation
        const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

        // UI Tests
        const val composeUiTesting = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object Retrofit {
        // Retrofit
        const val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Coil {
        const val accompanist = "com.google.accompanist:accompanist-glide:${Versions.accompanist}"
    }
}