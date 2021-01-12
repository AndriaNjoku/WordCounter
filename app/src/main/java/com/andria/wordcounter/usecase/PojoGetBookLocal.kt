package com.andria.wordcounter.usecase

import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.model.Book
import com.andria.wordcounter.repository.Books
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class PojoGetBookLocal @Inject constructor(private val repo: Books): GetBookLocal {

    override fun getBook(book: BOOKS): Flowable<String> = repo.getBook(book)

}