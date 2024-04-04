plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
    //hilt
    kotlin("kapt")
    id ("com.google.dagger.hilt.android")

    }

android {
    namespace = "com.ehsankhormali.firebaseexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ehsankhormali.firebaseexample"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.04.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.7")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.7.7")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))

    //
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // TODO: Add the dependencies for Firebase products you want to use

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth")

    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")

    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.51")
    kapt ("com.google.dagger:hilt-compiler:2.51")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.8.0")
    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //coil
    implementation ("io.coil-kt:coil-compose:2.6.0")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")

    // JSON Converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Icons
    implementation ("androidx.compose.material:material-icons-extended")

    //firestore
    implementation ("com.google.firebase:firebase-firestore-ktx:24.11.0")
    implementation ("com.google.firebase:firebase-storage:20.3.0")
}
// Allow references to generated code
kapt {
    correctErrorTypes=true
}