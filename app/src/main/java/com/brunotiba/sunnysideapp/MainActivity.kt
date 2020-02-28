package com.brunotiba.sunnysideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject

class MainActivity : AppCompatActivity() {

    val usecase : GetCurrentWeatherByCityName by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KTP.openRootScope().inject(this)
        GlobalScope.launch {
            usecase("Campinas")
        }
    }
}
