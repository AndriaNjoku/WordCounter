package com.andria.wordcounter.bookSelectionScreen.ui

import com.andria.wordcounter.BookStore
import com.andria.wordcounter.model.BOOKS
import io.reactivex.disposables.CompositeDisposable

class PojoBookSelectionPresenter(
    private val view: BookSelectionPresenter.View,
    private val bookStore: BookStore
) : BookSelectionPresenter{

    init {
        view.showBookDownloaded(BOOKS.RAILWAY_CHILDREN,bookStore.getRailwayChildrenStored())
    }

    override fun getWordCount(book: BOOKS) = view.showWordCount(book)



}