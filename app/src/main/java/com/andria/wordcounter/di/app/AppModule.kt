package com.andria.wordcounter.di.app

import android.app.Application
import android.content.Context
import com.andria.wordcounter.BookStore
import com.andria.wordcounter.BookStoreKeyValue
import com.andria.wordcounter.KeyValueStore
import com.andria.wordcounter.KeyValueStoreSharedPrefs
import com.andria.wordcounter.repository.Books
import com.andria.wordcounter.repository.LocalBooks
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {


    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideBookRepository(implementation: LocalBooks): Books = implementation


    @Provides
    fun provideKeyValueStore(context: Context): KeyValueStore = KeyValueStoreSharedPrefs(context)


    @Provides
    @Singleton
    fun provideBookStore(store: KeyValueStore): BookStore = BookStoreKeyValue(store)





}