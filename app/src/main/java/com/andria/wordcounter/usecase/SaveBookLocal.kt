package com.andria.wordcounter.usecase

import com.andria.wordcounter.model.BOOKS
import io.reactivex.Completable
import java.io.InputStream


interface SaveBookLocal {

    fun saveBook(book: BOOKS, inputStream: InputStream)
}