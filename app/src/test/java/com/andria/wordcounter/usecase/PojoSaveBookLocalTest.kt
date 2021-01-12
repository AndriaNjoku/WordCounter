package com.andria.wordcounter.usecase

import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.repository.Books
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import java.io.InputStream
import java.io.StringBufferInputStream
import java.io.StringReader


internal class PojoSaveBookLocalTest(){


    @Test
    fun `test that calling save book will call the repo to save`(){
            // Given
        val mockRepo = mock<Books>()

        val fakeInput = "This is the string that your fake input stream will return"
        val fakeStream: InputStream = StringBufferInputStream(fakeInput)

            val sut = PojoSaveBookLocal(mockRepo)

            //When
            sut.saveBook(BOOKS.RAILWAY_CHILDREN, fakeStream)

         //Then
            verify(mockRepo).saveBook(BOOKS.RAILWAY_CHILDREN, fakeStream)
        }
    }
