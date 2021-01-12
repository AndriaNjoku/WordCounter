package com.andria.wordcounter.usecase

import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.model.Book
import com.andria.wordcounter.repository.Books
import io.reactivex.Flowable
import io.reactivex.Observable


interface GetBookLocal {

    fun getBook(book: BOOKS) : Flowable<String>
}