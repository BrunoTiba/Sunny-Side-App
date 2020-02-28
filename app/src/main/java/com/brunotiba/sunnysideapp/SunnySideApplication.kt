package com.brunotiba.sunnysideapp

import android.app.Application
import com.brunotiba.domain.di.domainModule
import com.brunotiba.local.di.LocalModule
import com.brunotiba.remote.di.remoteModule
import com.brunotiba.repository.di.repositoryModule
import timber.log.Timber
import toothpick.ktp.KTP

internal class SunnySideApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initToothpick()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initToothpick() {
        KTP.openRootScope()
            .installModules(
                domainModule,
                repositoryModule,
                remoteModule,
                LocalModule(this)
            )
            .inject(this)
    }
}
