package com.androiddevs.mvvmnewsapp

import android.app.Application
import com.androiddevs.mvvmnewsapp.di.appModule
import com.androiddevs.mvvmnewsapp.di.databaseModule
import com.androiddevs.mvvmnewsapp.di.repoModule
import com.androiddevs.mvvmnewsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    databaseModule,
                    appModule,
                    repoModule,
                    viewModelModule
                )
            )
        }

    }

}