package com.brunotiba.sunnysideapp

import android.app.Application
import com.brunotiba.domain.di.domainModule
import com.brunotiba.remote.di.remoteModule
import com.brunotiba.repository.di.RepositoryModule
import toothpick.ktp.KTP

class SunnySideApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KTP.openRootScope()
            .installModules(domainModule, RepositoryModule(), remoteModule)
            .inject(this)
    }
}
