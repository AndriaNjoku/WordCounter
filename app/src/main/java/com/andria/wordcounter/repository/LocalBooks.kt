package com.andria.wordcounter.repository

import android.content.Context
import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.model.Book
import io.reactivex.Flowable
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.InputStream
import javax.inject.Inject

class LocalBooks @Inject constructor(
    private val context: Context
) : Books {

    private val path =  context.filesDir.absolutePath

    companion object {
        const val RAILWAY_CHILDREN = "/Railway-Children.txt"
    }

    override fun getBook(book: BOOKS): Flowable<String> = when (book) {
        BOOKS.RAILWAY_CHILDREN -> readFile(RAILWAY_CHILDREN)
        else -> Flowable.never()
    }

    override fun saveBook(book: BOOKS, bookStream: InputStream) {
        bookStream.toFile("$path$RAILWAY_CHILDREN")
    }

    private fun readFile(bookTextFile: String): Flowable<String> {
        return Flowable.using(
            {
                BufferedReader(
                    FileReader("$path$RAILWAY_CHILDREN")
                )
            },
            { reader: BufferedReader ->
                Flowable.fromIterable(
                    Iterable { reader.lines().iterator() })
            }
        ) { reader: BufferedReader -> reader.close() }
    }

    private fun InputStream.toFile(path: String) {
        use { input ->
            File(path).outputStream().use { input.copyTo(it) }
        }
    }
}

