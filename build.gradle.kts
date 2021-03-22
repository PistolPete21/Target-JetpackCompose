import gradle.*

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val gradleVersion by extra("7.0.0-alpha11")
    val kotlinVersion by extra("1.4.31")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}