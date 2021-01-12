package com.andria.wordcounter.wordCountScreen.ui

import com.andria.wordcounter.model.WordCount

interface WordCountPresenter {


    fun getWordCountRailwayChildren(): Boolean

    fun dispose()


    interface View {

        fun displayWordCount( words: List<WordCount>)


    }



}