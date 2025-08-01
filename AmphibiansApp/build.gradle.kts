// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("plugin.serialization") version "2.0.21"
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}