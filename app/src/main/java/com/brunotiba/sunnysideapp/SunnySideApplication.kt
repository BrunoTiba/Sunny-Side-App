package com.brunotiba.sunnysideapp

import android.app.Application
import com.brunotiba.domain.di.domainModule
import com.brunotiba.local.di.LocalModule
import com.brunotiba.remote.di.remoteModule
import com.brunotiba.repository.di.repositoryModule
import toothpick.ktp.KTP

internal class SunnySideApplication : Application() {

    override fun onCreate() {
        super.onCreate()

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
