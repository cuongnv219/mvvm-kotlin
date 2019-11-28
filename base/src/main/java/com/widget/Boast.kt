package com.widget

/*
 * Copyright (C) 2012 Glowworm Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import androidx.annotation.LayoutRes
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast

import java.lang.ref.WeakReference

/**
 * [Toast] decorator allowing for easy cancellation of notifications. Use this class if you
 * want subsequent Toast notifications to overwrite current ones.
 *
 *
 * By default, a current [Boast] notification will be cancelled by a subsequent notification.
 * This default behaviour can be changed by calling certain methods like [.show].
 */
class Boast
// ////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Private constructor creates a new [Boast] from a given [Toast].
 *
 * @throws NullPointerException if the parameter is `null`.
 */
private constructor(
        // ////////////////////////////////////////////////////////////////////////////////////////////////////////

        /**
         * Internal reference to the [Toast] object that will be displayed.
         */
        private val internalToast: Toast?) {
    init {
        // null check
        if (internalToast == null) {
            throw NullPointerException("Boast.Boast(Toast) requires a non-null parameter.")
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Close the view if it's showing, or don't show it if it isn't showing yet. You do not normally
     * have to call this. Normally view will disappear on its own after the appropriate duration.
     */
    fun cancel() {
        internalToast!!.cancel()
    }

    /**
     * Show the view for the specified duration. This method can be used to cancel the current
     * notification, or to queue up notifications.
     *
     * @param cancelCurrent `true` to cancel any current notification and replace it with this new
     * one
     *
     * @see .show
     */
    @JvmOverloads
    fun show(cancelCurrent: Boolean = true) {
        // cancel current
        if (cancelCurrent) {
            val cachedGlobalBoast = globalBoast
            cachedGlobalBoast?.cancel()
        }

        // save an instance of this current notification
        globalBoast = this

        internalToast!!.show()
    }

    companion object {
        /**
         * Keeps track of certain Boast notifications that may need to be cancelled. This functionality
         * is only offered by some of the methods in this class.
         *
         *
         * Uses a [WeakReference] to avoid leaking the activity context used to show the original [Toast].
         */
        @Volatile
        private var weakBoast: WeakReference<Boast>? = null

        private var globalBoast: Boast?
            get() = if (weakBoast == null) {
                null
            } else weakBoast!!.get()
            set(globalBoast) {
                Boast.weakBoast = WeakReference<Boast>(globalBoast)
            }

        // ////////////////////////////////////////////////////////////////////////////////////////////////////////

        /**
         * Make a standard [Boast] that just contains a text view.
         *
         * @param context  The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param text     The text to show. Can be formatted text.
         * @param duration How long to display the message. Either [Toast.LENGTH_SHORT] or
         * [Toast.LENGTH_LONG]
         */
        @SuppressLint("ShowToast")
        fun makeText(context: Context, text: CharSequence, duration: Int): Boast {
            return Boast(Toast.makeText(context, text, duration))
        }

        /**
         * Make a standard [Boast] that just contains a text view with the text from a resource.
         *
         * @param context  The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param resId    The resource id of the string resource to use. Can be formatted text.
         * @param duration How long to display the message. Either [Toast.LENGTH_SHORT] or
         * [Toast.LENGTH_LONG]
         *
         * @throws Resources.NotFoundException if the resource can't be found.
         */
        @SuppressLint("ShowToast")
        @Throws(Resources.NotFoundException::class)
        fun makeText(context: Context, resId: Int, duration: Int): Boast {
            return Boast(Toast.makeText(context, resId, duration))
        }

        /**
         * Make a standard [Boast] that just contains a text view. Duration defaults to
         * [Toast.LENGTH_SHORT].
         *
         * @param context The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param text    The text to show. Can be formatted text.
         */
        @SuppressLint("ShowToast")
        fun makeText(context: Context, text: CharSequence): Boast {
            return Boast(Toast.makeText(context, text, Toast.LENGTH_SHORT))
        }

        /**
         * Make a standard [Boast] that just contains a text view with the text from a resource.
         * Duration defaults to [Toast.LENGTH_SHORT].
         *
         * @param context The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param resId   The resource id of the string resource to use. Can be formatted text.
         *
         * @throws Resources.NotFoundException if the resource can't be found.
         */
        @SuppressLint("ShowToast")
        @Throws(Resources.NotFoundException::class)
        fun makeText(context: Context, resId: Int): Boast {
            return Boast(Toast.makeText(context, resId, Toast.LENGTH_SHORT))
        }

        /**
         * Make a custom [Boast] displays a given layout resource file.
         * Duration defaults to [Toast.LENGTH_SHORT].
         *
         * @param context     The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param layoutResId The resource id of the layout resource to use.
         *
         * @throws Resources.NotFoundException if the resource can't be found.
         */
        @SuppressLint("ShowToast")
        @Throws(Resources.NotFoundException::class)
        fun makeCustom(context: Context, @LayoutRes layoutResId: Int): Boast {
            val toast = Toast(context)
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.duration = Toast.LENGTH_SHORT
            val inflater = LayoutInflater.from(context)
            toast.view = inflater.inflate(layoutResId, null)

            return Boast(toast)
        }

        // ////////////////////////////////////////////////////////////////////////////////////////////////////////

        /**
         * Show a standard [Boast] that just contains a text view.
         *
         * @param context  The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param text     The text to show. Can be formatted text.
         * @param duration How long to display the message. Either [Toast.LENGTH_SHORT] or
         * [Toast.LENGTH_LONG]
         */
        fun showText(context: Context, text: CharSequence, duration: Int) {
            Boast.makeText(context, text, duration).show()
        }

        /**
         * Show a standard [Boast] that just contains a text view with the text from a resource.
         *
         * @param context  The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param resId    The resource id of the string resource to use. Can be formatted text.
         * @param duration How long to display the message. Either [Toast.LENGTH_SHORT] or
         * [Toast.LENGTH_LONG]
         *
         * @throws Resources.NotFoundException if the resource can't be found.
         */
        @Throws(Resources.NotFoundException::class)
        fun showText(context: Context, resId: Int, duration: Int) {
            Boast.makeText(context, resId, duration).show()
        }

        /**
         * Show a standard [Boast] that just contains a text view. Duration defaults to
         * [Toast.LENGTH_SHORT].
         *
         * @param context The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param text    The text to show. Can be formatted text.
         */
        fun showText(context: Context, text: CharSequence) {
            Boast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        /**
         * Show a standard [Boast] that just contains a text view with the text from a resource.
         * Duration defaults to [Toast.LENGTH_SHORT].
         *
         * @param context The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param resId   The resource id of the string resource to use. Can be formatted text.
         *
         * @throws Resources.NotFoundException if the resource can't be found.
         */
        @Throws(Resources.NotFoundException::class)
        fun showText(context: Context, resId: Int) {
            Boast.makeText(context, resId, Toast.LENGTH_SHORT).show()
        }

        /**
         * Show a custom [Boast] displays a given layout resource file.
         * Duration defaults to [Toast.LENGTH_SHORT].
         *
         * @param context     The context to use. Usually your [android.app.Application] or
         * [android.app.Activity] object.
         * @param layoutResId The resource id of the layout resource to use.
         *
         * @throws Resources.NotFoundException if the resource can't be found.
         */
        @Throws(Resources.NotFoundException::class)
        fun showCustom(context: Context, @LayoutRes layoutResId: Int) {
            Boast.makeCustom(context, layoutResId).show()
        }
    }
}
/**
 * Show the view for the specified duration. By default, this method cancels any current
 * notification to immediately display the new one. For conventional [Toast.show]
 * queueing behaviour, use method [.show].
 *
 * @see .show
 */