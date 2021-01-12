package com.andria.wordcounter.wordCountScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.andria.wordcounter.App
import com.andria.wordcounter.R
import com.andria.wordcounter.adapter.WordCountResultAdapter
import com.andria.wordcounter.di.wordcounter.WordCounterModule
import com.andria.wordcounter.model.BOOKS
import com.andria.wordcounter.model.WordCount
import com.andria.wordcounter.wordCountScreen.ui.WordCountPresenter
import kotlinx.android.synthetic.main.word_count_screen.*
import javax.inject.Inject

class WordCountActivity : AppCompatActivity() {


    companion object{

        private const val BOOK: String= "BOOK"

        fun intent(context: Context, book: BOOKS): Intent = Intent(context, WordCountActivity::class.java).putExtra(
            BOOK,book.name )
    }

    @Inject
    lateinit var presenter: WordCountPresenter

    lateinit var forecastAdapter : WordCountResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_count_screen)
        injectDependencies()

        wordCount.layoutManager = LinearLayoutManager(this)
        forecastAdapter = WordCountResultAdapter()
        wordCount.adapter = forecastAdapter

        presenter.getWordCountRailwayChildren()

    }

    private fun injectDependencies() {
        App.instance.component.plus(WordCounterModule(this)).inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()

    }

    internal class Delegate(private val activity: WordCountActivity): WordCountPresenter.View{

        override fun displayWordCount(list: List<WordCount>) {
            with(activity){
               forecastAdapter.setData(list)
            }

        }

    }

    }
