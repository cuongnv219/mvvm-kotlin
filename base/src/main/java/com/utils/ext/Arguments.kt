@file:Suppress("UNCHECKED_CAST")

package com.utils.ext

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.io.Serializable

/**
 * Start an Activity for given class T and allow to work on intent with "run" lambda function
 */
fun androidx.fragment.app.Fragment.withArguments(vararg arguments: Pair<String, Serializable>): androidx.fragment.app.Fragment {
    val bundle = Bundle()
    arguments.forEach { bundle.putSerializable(it.first, it.second) }
    this.arguments = bundle
    return this
}

/**
 * Retrieve property from intent
 */
fun <T : Any> androidx.fragment.app.FragmentActivity.argument(key: String) = lazy { intent.extras!![key] as T }

/**
 * Retrieve property with default value from intent
 */
fun <T : Any> androidx.fragment.app.FragmentActivity.argument(key: String, defaultValue: T? = null) = lazy {
    intent.extras!![key] as? T ?: defaultValue
}

/**
 * Retrieve property from intent
 */
fun <T : Any> androidx.fragment.app.Fragment.argument(key: String) = lazy { arguments?.get(key) as T }

/**
 * Retrieve property with default value from intent
 */
fun <T : Any> androidx.fragment.app.Fragment.argument(key: String, defaultValue: T? = null) = lazy {
    arguments?.get(key)  as? T ?: defaultValue
}
