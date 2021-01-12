package com.andria.wordcounter.bookSelectionScreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.andria.wordcounter.App
import com.andria.wordcounter.R
import com.andria.wordcounter.bookSelectionScreen.ui.BookSelectionPresenter
import com.andria.wordcounter.di.wordcounter.WordCounterModule
import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.wordCountScreen.WordCountActivity
import kotlinx.android.synthetic.main.book_selection_screen.*
import javax.inject.Inject

class BookSelectionActivity : AppCompatActivity() {


    @Inject
    lateinit var presenter: BookSelectionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_selection_screen)

        injectDependencies()

        railwayChildren.setOnClickListener {
            presenter.getWordCount(BOOKS.RAILWAY_CHILDREN)
            Toast.makeText(this," Pressed the button",Toast.LENGTH_SHORT).show()
        }
    }

    private fun injectDependencies() {
        App.instance.component.plus(WordCounterModule(this)).inject(this)
    }

    internal class Delegate(private val activity: BookSelectionActivity): BookSelectionPresenter.View{

        override fun showWordCount(book: BOOKS) {
           activity.startActivity(WordCountActivity.intent(activity,book))
        }

        override fun showBookDownloaded(book: BOOKS, isStored: Boolean) = when(book){
            BOOKS.RAILWAY_CHILDREN -> when(isStored){
                true -> activity.railwayChidrenStored.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.dot_downloaded))
                false ->  activity.railwayChidrenStored.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.dot_not_downloaded))
            }
            BOOKS.NONE -> TODO()
        }


    }

    }
