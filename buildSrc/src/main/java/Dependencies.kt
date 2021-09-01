object Versions {
    const val minSdk = 26
    const val targetSdk = 31
    const val compileSdk = 31
    const val buildTools = "30.0.2"
    const val gradlePlugin = "7.0.1"
    const val ktlintGradle = "10.1.0"

    const val kotlinVersion = "1.5.30"

    const val coreKtx = "1.6.0"
    const val androidXVersion = "1.3.1"
    const val constraintLayout = "2.1.0"

    const val hilt = "2.38.1"

    const val loggingInterceptor = "4.9.1"
    const val retrofit = "2.9.0"

    const val coroutines = "1.5.1"

    const val room = "2.3.0"

    const val timber = "5.0.1"

    const val junit = "4.13.2"
    const val androidJUnit = "1.1.3"
    const val espresso = "3.4.0"
    const val mockk = "1.12.0"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    val androidX = AndroidX
    val test = Test
    val okHttp = OkHttp
    val retrofit = Retrofit
    val room = Room
    val kotlinX = KotlinX
    val logging = Logging
    val hilt = Hilt
    val buildTools = BuildTools
}

object AndroidX {
    val core = "androidx.core:core-ktx:${Versions.coreKtx}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.androidXVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object BuildTools {
    val gradle = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlintGradle}"
}

object Hilt {
    val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}

object KotlinX {
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object Logging {
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object OkHttp {
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
}

object Room {
    val runtime = "androidx.room:room-runtime:${Versions.room}"
    val kapt = "androidx.room:room-compiler:${Versions.room}"
    val kotlinExtensions = "androidx.room:room-ktx:${Versions.room}"
}

object Test {
    val junit = "junit:junit:${Versions.junit}"
    val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val room = "androidx.room:room-testing:${Versions.room}"
}
