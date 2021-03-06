package com.lightningkite.kotlin.anko.async

import android.view.View
import com.lightningkite.kotlin.anko.isAttachedToWindowCompat

/**
 * Created by jivie on 1/22/16.
 */

fun <T> (() -> T).cancelling(view: View, default: T): () -> T {
    return {
        if (!view.isAttachedToWindowCompat()) default
        else this.invoke()
    }
}

fun <T> (() -> T).cancelling(view: View): () -> T? {
    return {
        if (!view.isAttachedToWindowCompat()) null
        else this.invoke()
    }
}