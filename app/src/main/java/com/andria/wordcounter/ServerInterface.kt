package com.andria.wordcounter

import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

interface ServerInterface {

    @Streaming
    @GET
    fun downloadFileFlowable(@Url fileUrl :String): Flowable<Response<ResponseBody>>

    @GET
    fun downloadFile(@Url fileUrl :String): Observable<Response<ResponseBody>>


}