package com.brunotiba.sunnysideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var useCase: GetCurrentWeatherByCityName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            Timber.d(useCase("Campinas").toString())
        }
    }
}
