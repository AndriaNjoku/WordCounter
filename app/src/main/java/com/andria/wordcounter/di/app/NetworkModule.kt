package com.andria.wordcounter.di.app

import com.andria.wordcounter.ServerInterface
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object{
        const val INITIAL_BASE_URL = "http://www.loyalbooks.com/download/text/"
    }


    @Provides
    @Singleton
    internal fun providesServerInterface(retrofit: Retrofit): ServerInterface = retrofit.create(ServerInterface::class.java)


    @Provides
    internal fun providesOkHttpClient() =
        with(OkHttpClient.Builder()) {
            connectTimeout(180, TimeUnit.SECONDS)
            writeTimeout(180, TimeUnit.SECONDS)
            readTimeout(180, TimeUnit.SECONDS)
            build()
        }

    @Provides
    @Singleton
    internal fun providesRetrofit(client: OkHttpClient) = with(Retrofit.Builder()) {
        baseUrl(INITIAL_BASE_URL)
        client(client)
        addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        build()
    }





}