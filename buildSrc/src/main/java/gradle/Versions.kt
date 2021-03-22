package gradle

object Versions {

    const val kotlin = "1.4.31"
    const val coroutines = "1.4.2"
    const val appCompat = "1.2.0"
    const val compose = "1.0.0-beta02"
    const val core = "1.3.2"

    const val composeActivity = "1.3.0-alpha04"
    const val composeConstraintLayout = "1.0.0-alpha03"
    const val composeNavigation = "1.0.0-alpha09"

    const val googleMaterial = "1.2.1"

    const val retrofit = "2.9.0"

    const val accompanist = "0.6.2"

    const val gradle = "7.0.0-alpha10"

    object AndroidConfig {

        const val minSdk = 21
        const val compileSdk = 30
        const val targetSdk = 30

        const val versionCode = 1
        const val versionName = "1.0.0"

        const val applicationId = "com.example.targetcasestudy_kotlincompose"

        const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"

        const val buildEnvironment = "release"

        const val proguardConfigFile = "proguard-android-optimize.txt"
        const val proguardRules = "proguard-rules.pro"
    }
}