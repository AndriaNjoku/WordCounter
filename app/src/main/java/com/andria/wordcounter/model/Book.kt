package com.andria.wordcounter.model

data class Book(val title: String, val author: String, val book: String){

    companion object{
        val EMPTY = Book("","", "")
    }


}