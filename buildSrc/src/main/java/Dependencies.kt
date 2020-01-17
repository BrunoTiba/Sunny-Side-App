object Versions {
    const val minSdk = 23
    const val targetSdk = 28
    const val compileSdk = 28
    const val buildTools = "29.0.2"

    const val kotlinVersion = "1.3.61"

    const val androidXVersion = "1.1.0"
    const val constraintLayout = "1.1.3"

    const val toothpick = "3.1.0"

    const val junit = "4.12"
    const val androidJUnit = "1.1.1"
    const val espresso = "3.2.0"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    val androidX = AndroidX
    val test = Test
    val toothpick = Toothpick
}

object AndroidX {
    val core = "androidx.core:core-ktx:${Versions.androidXVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.androidXVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Toothpick {
    val di = "com.github.stephanenicolas.toothpick:ktp:${Versions.toothpick}"
    val kapt = "com.github.stephanenicolas.toothpick:toothpick-compiler:${Versions.toothpick}"
}

object Test {
    val junit = "junit:junit:${Versions.junit}"
    val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
