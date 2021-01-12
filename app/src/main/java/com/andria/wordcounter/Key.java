package com.andria.wordcounter;

import androidx.annotation.StringDef;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        Key.BOOK_STORED_RAILWAY,
})
@Retention(RetentionPolicy.SOURCE)
public @interface Key {
    String BOOK_STORED_RAILWAY = "BOOK_STORED_RAILWAY_CHILDREN";

}
