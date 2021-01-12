package com.andria.wordcounter.repository

import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.model.Book
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.InputStream
import java.util.stream.Stream

interface Books {


    fun getBook(book: BOOKS): Flowable<String>

    fun saveBook(book: BOOKS, bookText: InputStream)
}