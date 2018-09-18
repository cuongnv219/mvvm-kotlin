package com.utils

import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * ka
 * 08/11/2017
 */

object UIHelper {

    /**
     * get display size
     *
     * @param context: Context
     *
     * @return: point(display size)
     */
    fun getDisplaySize(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager?
        val outSize = Point()
        windowManager?.defaultDisplay?.getSize(outSize)
        return outSize
    }

    /**
     * get display shorter side size
     *
     * @param context: Context
     *
     * @return size of display shorter side
     */
    fun getDisplayShorterSideSize(context: Context): Int {
        val outSize = getDisplaySize(context)
        return if (outSize.x < outSize.y) outSize.x else outSize.y
    }

    /**
     * calculate column of grid with cell width, will use when display image in grid view
     *
     * @param context:   Context
     * @param cellWidth: cell width
     *
     * @return: number of column
     */
    fun calcGridColumn(context: Context, cellWidth: Int): Int {
        val displaySize = getDisplaySize(context)
        val width = displaySize.x
        return width / cellWidth
    }

    fun getScreenOrientation(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val orientation: Int
        orientation = if (display.width == display.height) {
            Configuration.ORIENTATION_SQUARE
        } else {
            if (display.width < display.height) {
                Configuration.ORIENTATION_PORTRAIT
            } else {
                Configuration.ORIENTATION_LANDSCAPE
            }
        }
        return orientation
    }

    fun dpToPx(context: Context, dp: Float): Int {
        // Took from http://stackoverflow.com/questions/8309354/formula-px-to-dp-dp-to-px-android
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    fun getScreenWidth(context: Context?): Int {
        return if (context == null) {
            0
        } else getDisplayMetrics(context).widthPixels
    }

    /**
     * Returns a valid DisplayMetrics object
     *
     * @param context valid context
     *
     * @return DisplayMetrics object
     */
    fun getDisplayMetrics(context: Context): DisplayMetrics {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager?
        val metrics = DisplayMetrics()
        windowManager?.defaultDisplay?.getMetrics(metrics)
        return metrics
    }

    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources
                .getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}
