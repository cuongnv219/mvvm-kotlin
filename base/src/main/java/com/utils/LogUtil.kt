package com.utils

import android.util.Log

object LogUtil {
    private var DEBUG = true
    var tag = "Fucking Log"

    fun init(isDebug: Boolean) {
        DEBUG = isDebug
    }

    fun v(tag: String, msg: String) {
        if (DEBUG) {
            Log.v(tag, msg)
        }
    }

    fun v(msg: String) {
        if (DEBUG) {
            Log.v(tag, msg)
        }
    }

    fun debug(tag: String, msg: String) {
        if (DEBUG) {
            Log.d(tag, msg)
        }
    }

    fun debug(msg: String) {
        if (DEBUG) {
            Log.d(tag, msg)
        }
    }

    fun info(tag: String, msg: String) {
        if (DEBUG) {
            Log.i(tag, msg)
        }
    }

    fun info(msg: String) {
        if (DEBUG) {
            Log.i(tag, msg)
        }
    }

    fun warning(tag: String, msg: String) {
        if (DEBUG) {
            Log.w(tag, msg)
        }
    }

    fun warning(msg: String) {
        if (DEBUG) {
            Log.w(tag, msg)
        }
    }

    fun error(tag: String, msg: String) {
        if (DEBUG) {
            Log.e(tag, msg)
        }
    }

    fun error(msg: String) {
        if (DEBUG) {
            Log.e(tag, msg)
        }
    }
}
