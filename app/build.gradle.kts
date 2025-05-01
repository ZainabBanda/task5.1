plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mine.newsapp2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mine.newsapp2"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Room runtime
    implementation("androidx.room:room-runtime:2.5.0")
    // Room compiler (for Java use annotationProcessor; for Kotlin use kapt)
    annotationProcessor("androidx.room:room-compiler:2.5.0")

}
