package com.andria.wordcounter.di.wordcounter

import android.app.Activity
import com.andria.wordcounter.bookSelectionScreen.BookSelectionActivity
import com.andria.wordcounter.wordCountScreen.WordCountActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [WordCounterModule::class])
    interface WordCounterComponent: AndroidInjector<Activity> {

        // Inject this componenet and provide dependencies to our main word count activity
        // There are no use cases needed for the book selection activity as its just a UI with buttons essentially
        fun inject(activity: WordCountActivity)

        fun inject(activity: BookSelectionActivity)


}

