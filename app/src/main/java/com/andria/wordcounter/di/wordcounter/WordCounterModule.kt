package com.andria.wordcounter.di.wordcounter



import android.app.Activity
import android.content.Context
import com.andria.wordcounter.BookStore
import com.andria.wordcounter.bookSelectionScreen.BookSelectionActivity
import com.andria.wordcounter.bookSelectionScreen.ui.BookSelectionPresenter
import com.andria.wordcounter.bookSelectionScreen.ui.PojoBookSelectionPresenter
import com.andria.wordcounter.usecase.*
import com.andria.wordcounter.wordCountScreen.WordCountActivity
import com.andria.wordcounter.wordCountScreen.ui.PojoWordCountPresenter
import com.andria.wordcounter.wordCountScreen.ui.WordCountPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers

@Module
class WordCounterModule(private val activity: Activity) {

    @Provides
    fun providesWordCountView(): WordCountPresenter.View = WordCountActivity.Delegate(activity as WordCountActivity)

    @Provides
    fun providesWordCountPresenter(
        view: WordCountPresenter.View,
        context: Context,
        library: BookStore,
        saveLocal: SaveBookLocal,
        getLocal: GetBookLocal,
        getNet: GetBookNet
    ): WordCountPresenter = PojoWordCountPresenter(view, context, library, getLocal, saveLocal, getNet, AndroidSchedulers.mainThread())

    @Provides
    fun providesBookSelectionView(): BookSelectionPresenter.View = BookSelectionActivity.Delegate(activity as BookSelectionActivity)

    @Provides
    fun providesPresenter(
        view: BookSelectionPresenter.View,
        bookStore: BookStore
    ): BookSelectionPresenter = PojoBookSelectionPresenter(view, bookStore)

    @Provides
    fun saveBookLocal(implementation: PojoSaveBookLocal) : SaveBookLocal = implementation

    @Provides
    fun providesGetBookLocal(implementation: PojoGetBookLocal) : GetBookLocal = implementation

    @Provides
    fun providesGetBookNet(implementation: PojoGetBookNet) : GetBookNet = implementation

}
