package com.andria.wordcounter.usecase

import com.andria.wordcounter.ServerInterface
import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.repository.Books
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PojoGetBookNetTest(){


    @Test
    fun `test that calling getBook() will call the server with correct method`(){

        // Given

        val mockRepo = mock<ServerInterface> {
            on { downloadFile(any()) } doReturn Observable.never()
            on { downloadFileFlowable(any()) } doReturn Flowable.never()
        }

        val sut = PojoGetBookNet(mockRepo)

        //When
        sut.getBook(BOOKS.RAILWAY_CHILDREN)


        //Then
        verify(mockRepo).downloadFileFlowable(any())
    }

    @Test
    fun `test that calling getBookStream() will call the server with correct method`(){

        // Given

        val mockRepo = mock<ServerInterface> {
            on { downloadFile(any()) } doReturn Observable.never()
            on { downloadFileFlowable(any()) } doReturn Flowable.never()
        }

        val sut = PojoGetBookNet(mockRepo)

        //When
        sut.getBookStream(BOOKS.RAILWAY_CHILDREN)


        //Then
        verify(mockRepo).downloadFile(any())
    }
}