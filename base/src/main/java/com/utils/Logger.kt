package com.utils

import android.util.Log

/**
 * ka
 * 08/11/2017
 */

class Logger private constructor(clazz: Class<*>) {

    private val tag: String = clazz.simpleName

    fun debug(msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.d(tag, msg.toString())
            }
        }
    }

    fun debug(tag: String, msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.d(tag, msg.toString())
            }
        }
    }

    fun debug(msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.d(tag, msg.toString(), tr)
            } else {
                Log.d(tag, "Exception", tr)
            }
        }
    }

    fun debug(tag: String, msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.d(tag, msg.toString(), tr)
            } else {
                Log.d(tag, "Exception", tr)
            }
        }
    }

    fun info(msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.i(tag, msg.toString())
            }
        }
    }

    fun info(tag: String, msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.i(tag, msg.toString())
            }
        }
    }

    fun info(msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.i(tag, msg.toString(), tr)
            } else {
                Log.i(tag, "Exception", tr)
            }
        }
    }

    fun info(tag: String, msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.i(tag, msg.toString(), tr)
            } else {
                Log.i(tag, "Exception", tr)
            }
        }
    }

    fun warn(msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.w(tag, msg.toString())
            }
        }
    }

    fun warn(tag: String, msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.w(tag, msg.toString())
            }
        }
    }

    fun warn(tag: String, msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.w(tag, msg.toString(), tr)
            } else {
                Log.w(tag, "Exception", tr)
            }
        }
    }

    fun error(msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.e(tag, msg.toString())
            }
        }
    }

    fun error(tag: String, msg: Any?) {
        if (isDebug) {
            if (msg != null) {
                Log.e(tag, msg.toString())
            }
        }
    }

    fun error(msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.e(tag, msg.toString(), tr)
            } else {
                Log.e(tag, "Exception", tr)
            }
        }
    }

    fun error(tag: String, msg: Any?, tr: Throwable) {
        if (isDebug) {
            if (msg != null) {
                Log.e(tag, msg.toString(), tr)
            } else {
                Log.e(tag, "Exception", tr)
            }
        }
    }

    companion object {

        private var isDebug = false

        fun init(isDebug: Boolean) {
            Logger.isDebug = isDebug
        }

        fun getLogger(clazz: Class<*>): Logger {
            return Logger(clazz)
        }
    }
}
