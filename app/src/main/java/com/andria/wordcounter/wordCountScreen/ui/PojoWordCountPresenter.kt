package com.andria.wordcounter.wordCountScreen.ui

import android.content.Context
import android.util.Log
import com.andria.wordcounter.BookStore
import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.model.WordCount
import com.andria.wordcounter.usecase.GetBookLocal
import com.andria.wordcounter.usecase.GetBookNet
import com.andria.wordcounter.usecase.SaveBookLocal
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class PojoWordCountPresenter(
    val view: WordCountPresenter.View,
    private val context: Context,
    private val library: BookStore,
    private val getBooksLocal: GetBookLocal,
    private val saveBookLocal: SaveBookLocal,
    private val getBookNet: GetBookNet,
    private val foreground: Scheduler
) : WordCountPresenter {


    private val words = mutableListOf<String>()

    var compositeDisposable = CompositeDisposable()

    override fun getWordCountRailwayChildren() = when (library.getRailwayChildrenStored()) {
        true -> compositeDisposable.add(
            getBooksLocal.getBook(BOOKS.RAILWAY_CHILDREN)
                .doOnNext {
                    val r = Regex("""\p{javaLowerCase}+""")
                    val matches = r.findAll(it)
                    val areWords = matches.map { it.value }
                        .groupBy { it }
                        .map { it.key }
                    words.addAll(areWords.filter { it.length > 2 })
                }
                .doOnSubscribe { Log.e(" wordCountPresenter", " Fetching Railway Children") }
                .subscribeOn(Schedulers.io())
                .observeOn(foreground)
                .doOnComplete {
                    val result = words.groupingBy { it }.eachCount().map {
                        WordCount(it.key, it.value, isPrimeNumber(it.value))
                    }
                    view.displayWordCount(result)
                }
                .subscribe())
        false -> compositeDisposable.add(
            getBookNet.getBook(BOOKS.RAILWAY_CHILDREN)
                .doOnNext {
                    val r = Regex("""\p{javaLowerCase}+""")
                    val matches = r.findAll(it)
                    val areWords = matches.map { it.value }
                        .groupBy { it }
                        .map { it.key }
                    words.addAll(areWords.filter { it.length > 2 })
                }
                .doOnSubscribe { Log.e(" wordCountPresenter", " Fetching Railway Children") }
                .subscribeOn(Schedulers.io())
                .observeOn(foreground)
                .doOnComplete {
                    val result = words.groupingBy { it }.eachCount().map {
                        WordCount(it.key, it.value, isPrimeNumber(it.value))
                    }
                    view.displayWordCount(result)
                }
                .doFinally { saveBookRailwayChildren() }
                .subscribe())
    }

    private fun isPrimeNumber(value: Int): Boolean {
        if (value == 1) return false
        var flag = false
        for (i in 2..value / 2) {
            if (value % i == 0) {
                flag = true
                break
            }
        }
        return !flag
    }

    private fun saveBookRailwayChildren() = compositeDisposable.add(
        getBookNet.getBookStream(BOOKS.RAILWAY_CHILDREN)
            .doOnSubscribe {
                Log.e(" wordCountPresenter", " Saving Railway children to internal storage")
            }
            .subscribeOn(Schedulers.io())
            .doOnComplete { library.putRailwayChildrenStored(true) }
            .observeOn(foreground)
            .subscribe {
                saveBookLocal.saveBook(BOOKS.RAILWAY_CHILDREN, it)
            }
    )


    override fun dispose() {
        compositeDisposable.dispose()
    }
}