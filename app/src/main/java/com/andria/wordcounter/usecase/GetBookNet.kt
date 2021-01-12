package com.andria.wordcounter.usecase

import com.andria.wordcounter.model.BOOKS
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.InputStream


interface GetBookNet {

    fun getBook(book: BOOKS) : Flowable<String>

    fun getBookStream(book: BOOKS): Observable<InputStream>
}