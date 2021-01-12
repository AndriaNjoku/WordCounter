package com.andria.wordcounter

import android.content.Context
import com.andria.wordcounter.KeyValueStore

internal class KeyValueStoreSharedPrefs(context: Context) : KeyValueStore {

    private val preferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    override fun getBoolean(key: String): Boolean = preferences.getBoolean(key, false)

    override fun putBoolean(key: String, value: Boolean) =
        with(preferences.edit()) {
            putBoolean(key, value) }.apply()
}
