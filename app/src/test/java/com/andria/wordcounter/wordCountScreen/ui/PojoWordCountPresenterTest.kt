package com.andria.wordcounter.wordCountScreen.ui

import com.andria.wordcounter.BookStore
import com.andria.wordcounter.usecase.GetBookLocal
import com.andria.wordcounter.usecase.GetBookNet
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Test

internal class PojoWordCountPresenterTest(){



    @Test
    fun `test that presnter calls getBookNet when the book isnt downloaded`(){

        //Given
        val mockGetBookNet = mock<GetBookNet> { on{ getBook(any())} doReturn Flowable.never()}
        val bookStoreMock = mock<BookStore> { on{ getRailwayChildrenStored()} doReturn false }

        val sut =PojoWordCountPresenter(
            mock(),
            mock(),
            bookStoreMock,
            mock(),
            mock(),
            mockGetBookNet,
            Schedulers.trampoline()
        )

        //when
        sut.getWordCountRailwayChildren()

        verify(mockGetBookNet).getBook(any())

    }

    @Test
    fun `test that presnter calls getBookLocal when the book is downloaded`(){

        //Given
        val mockGetBookLocal = mock<GetBookLocal> { on{ getBook(any())} doReturn Flowable.never()}
        val bookStoreMock = mock<BookStore> { on{ getRailwayChildrenStored()} doReturn true}

        val sut =PojoWordCountPresenter(
            mock(),
            mock(),
            bookStoreMock,
            mockGetBookLocal,
            mock(),
            mock(),
            Schedulers.trampoline()
        )

        //when
        sut.getWordCountRailwayChildren()

        verify(mockGetBookLocal).getBook(any())

    }
}