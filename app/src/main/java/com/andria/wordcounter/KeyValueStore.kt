package com.andria.wordcounter

interface KeyValueStore {

    fun getBoolean(@Key key: String): Boolean

    fun putBoolean(@Key key: String, value: Boolean)
}
