package com.andria.wordcounter

import android.content.Context
import javax.inject.Inject

interface BookStore{
    fun getRailwayChildrenStored(): Boolean
    fun putRailwayChildrenStored(value: Boolean)
}
