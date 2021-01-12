package com.andria.wordcounter.bookSelectionScreen.ui

import com.andria.wordcounter.BookStore
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PojoBookSelectionPresenterTest()
{



    @Test
    fun `test that on initialisation the presenter will load the download status `(){

        //Given
        val mockBookStore = mock<BookStore>{ on { getRailwayChildrenStored()} doReturn true}

        PojoBookSelectionPresenter(
            mock(),
            mockBookStore
        )

        // No when using init

        //Then
        verify(mockBookStore).getRailwayChildrenStored()

    }


    @Test
    fun `test that download status is passed to the view`(){

        //Given
        val mockView = mock<BookSelectionPresenter.View>()
        val mockBookStore = mock<BookStore>{ on { getRailwayChildrenStored()} doReturn true}

        PojoBookSelectionPresenter(
            mockView,
            mockBookStore
        )

        // No when using init

        //Then
        verify(mockView).showBookDownloaded(any(),any())

    }
}