package com.andria.wordcounter.usecase

import com.andria.wordcounter.ServerInterface
import com.andria.wordcounter.model.BOOKS
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.BufferedReader
import java.io.InputStream
import java.io.StringReader
import javax.inject.Inject

class PojoGetBookNet @Inject constructor(private val serverInterface: ServerInterface) :
    GetBookNet {

    companion object {
        const val BOOK_RAILWAY_CHILDREN = "Railway-Children-by-E-Nesbit.txt"
    }

    override fun getBook(book: BOOKS): Flowable<String> = when (book) {
        BOOKS.RAILWAY_CHILDREN -> {
            serverInterface.downloadFileFlowable(BOOK_RAILWAY_CHILDREN)
                .flatMap {
                    val result = it.body() ?: throw error(" The response body is empty")
                    Flowable.using(
                        {
                            BufferedReader(
                                StringReader(
                                    result.string()
                                )
                            )
                        },
                        { reader: BufferedReader ->
                            Flowable.fromIterable(
                                Iterable { reader.lines().iterator() })
                        }
                    ) { reader: BufferedReader -> reader.close() }


                }
        }
        else -> Flowable.never()
    }

    override fun getBookStream(book: BOOKS): Observable<InputStream> = when (book) {
        BOOKS.RAILWAY_CHILDREN -> serverInterface.downloadFile(BOOK_RAILWAY_CHILDREN)
            .map {
                it.body()?.byteStream()

            }
        else -> Observable.never()
    }
}



