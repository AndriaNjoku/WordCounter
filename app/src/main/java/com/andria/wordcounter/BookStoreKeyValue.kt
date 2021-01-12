package com.andria.wordcounter

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookStoreKeyValue @Inject constructor(private val store: KeyValueStore): BookStore{

    override fun getRailwayChildrenStored(): Boolean = store.getBoolean(Key.BOOK_STORED_RAILWAY)

    override fun putRailwayChildrenStored(value: Boolean) = store.putBoolean(Key.BOOK_STORED_RAILWAY, value)


}
