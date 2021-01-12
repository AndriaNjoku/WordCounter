package com.andria.wordcounter.usecase

import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.repository.Books
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Flowable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PojoGetBookLocalTest(){


    @Test
    fun `test that the use case calls the repo when prompted`(){

        // Given

        val mockRepo = mock<Books> { on{getBook(com.nhaarman.mockitokotlin2.any())} doReturn Flowable.never()}

        val sut = PojoGetBookLocal(mockRepo)

        sut.getBook(BOOKS.RAILWAY_CHILDREN)

        verify(mockRepo).getBook(BOOKS.RAILWAY_CHILDREN)
    }
}