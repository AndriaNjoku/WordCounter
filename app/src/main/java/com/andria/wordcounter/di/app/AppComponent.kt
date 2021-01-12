package com.andria.wordcounter.di.app

import com.andria.wordcounter.App
import com.andria.wordcounter.di.wordcounter.WordCounterComponent
import com.andria.wordcounter.di.wordcounter.WordCounterModule
import javax.inject.Singleton

import dagger.Component
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent: AndroidInjector<App>{

   // App component provides
//    val userRepository: ForecastDatabase
//    val apiService: ForecastService

    // inject at scope
    fun plus(mySubmodule: WordCounterModule) : WordCounterComponent



}
