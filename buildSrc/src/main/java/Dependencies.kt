object Versions {
    const val kotlinVersion = "1.3.61"

    const val androidXVersion = "1.1.0"
    const val constraintLayout = "1.1.3"

    const val junit = "4.12"
    const val androidJUnit = "1.1.1"
    const val espresso = "3.2.0"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    val androidX = AndroidX
    val test = Test
}

object AndroidX {
    val core = "androidx.core:core-ktx:${Versions.androidXVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.androidXVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Test {
    val junit = "junit:junit:${Versions.junit}"
    val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
