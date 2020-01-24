package com.brunotiba.sunnysideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject

class MainActivity : AppCompatActivity() {

    val usecase: GetCurrentWeatherByCityName by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KTP.openRootScope().inject(this)
        usecase("hey")
    }
}
