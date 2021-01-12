package com.andria.wordcounter.bookSelectionScreen.ui

import com.andria.wordcounter.model.BOOKS

interface BookSelectionPresenter {


    fun getWordCount(book: BOOKS)



    interface View {

        fun showWordCount(book: BOOKS)
        fun showBookDownloaded(book: BOOKS, railwayChildrenStored: Boolean)

    }



}