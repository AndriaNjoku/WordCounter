package com.andria.wordcounter.usecase

import android.content.Context
import com.andria.wordcounter.BookStore
import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.repository.Books
import io.reactivex.Completable
import java.io.File
import java.io.InputStream
import java.net.URI
import javax.inject.Inject


class PojoSaveBookLocal @Inject constructor(
    private val repo: Books) : SaveBookLocal {

    override fun saveBook(book: BOOKS, bookStream: InputStream) =repo.saveBook(book, bookStream)

}