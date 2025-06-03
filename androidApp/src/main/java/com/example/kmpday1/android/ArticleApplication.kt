package com.example.kmpday1.android

import android.app.Application
import com.example.kmpday1.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ArticleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val allModules = sharedKoinModule + viewModelModule
        startKoin {
            androidContext(this@ArticleApplication)
            modules(allModules)
        }
    }
}