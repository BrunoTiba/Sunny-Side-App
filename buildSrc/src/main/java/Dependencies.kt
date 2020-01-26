object Versions {
    const val minSdk = 26
    const val targetSdk = 29
    const val compileSdk = 29
    const val buildTools = "29.0.2"

    const val kotlinVersion = "1.3.61"

    const val androidXVersion = "1.1.0"
    const val constraintLayout = "1.1.3"

    const val toothpick = "3.1.0"

    const val loggingInterceptor = "4.3.1"
    const val retrofit = "2.7.1"

    const val coroutines = "1.3.3"

    const val room = "2.2.3"

    const val junit = "4.12"
    const val androidJUnit = "1.1.1"
    const val espresso = "3.2.0"
    const val mockk = "1.9.3"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    val androidX = AndroidX
    val test = Test
    val toothpick = Toothpick
    val okHttp = OkHttp
    val retrofit = Retrofit
    val room = Room
    val kotlinX = KotlinX
}

object AndroidX {
    val core = "androidx.core:core-ktx:${Versions.androidXVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.androidXVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object KotlinX {
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object Toothpick {
    val di = "com.github.stephanenicolas.toothpick:ktp:${Versions.toothpick}"
    val kapt = "com.github.stephanenicolas.toothpick:toothpick-compiler:${Versions.toothpick}"
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
    val toothpick = "com.github.stephanenicolas.toothpick:toothpick-testing:${Versions.toothpick}"
    val toothpickJUnit =
        "com.github.stephanenicolas.toothpick:toothpick-testing-junit4:${Versions.toothpick}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val room = "androidx.room:room-testing:${Versions.room}"
}
