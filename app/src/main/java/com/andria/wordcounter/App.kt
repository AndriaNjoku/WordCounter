package com.andria.wordcounter

import android.app.Application
import com.andria.wordcounter.di.app.AppComponent
import com.andria.wordcounter.di.app.AppModule
import com.andria.wordcounter.di.app.DaggerAppComponent
import com.andria.wordcounter.di.app.NetworkModule
import net.danlew.android.joda.JodaTimeAndroid

class App : Application() {

    companion object {
        lateinit var instance: App private set
    }

    lateinit var component: AppComponent

        private set

    override fun onCreate() {
        super.onCreate()
        instance =this
        setup()

    }

    private fun setup() {

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
                component.inject(this)


        JodaTimeAndroid.init(this)

    }



}


