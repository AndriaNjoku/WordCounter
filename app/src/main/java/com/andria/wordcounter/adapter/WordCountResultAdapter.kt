package com.andria.wordcounter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andria.wordcounter.R
import com.andria.wordcounter.model.WordCount
import kotlinx.android.synthetic.main.word_count_item.view.*
import java.util.*

class WordCountResultAdapter() : RecyclerView.Adapter<WordCountResultAdapter.WordCountViewHolder>() {

    private val wordCountList: MutableList<WordCount>

    init {
        wordCountList = ArrayList()
    }

    fun setData(days: List<WordCount>) {
        Objects.requireNonNull(days)
        wordCountList.clear()
        wordCountList.addAll(days)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordCountViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.word_count_item, parent, false)

        return WordCountViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: WordCountViewHolder, position: Int) {
        holder.bind(wordCountList[position])
    }

    override fun getItemCount(): Int {
        return wordCountList.size
    }

    class WordCountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bind(word: WordCount) {

            itemView.word.text = word.word
            itemView.count.text = word.count.toString()
            itemView.isPrime.text = word.isPrime.toString()







        }


    }
}
