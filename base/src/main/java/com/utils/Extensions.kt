package com.utils

import android.app.Activity
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Kaz on 14:13 8/27/18
 */
fun ViewGroup.inflateExt(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)

fun Activity.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Fragment.toast(msg: String) {
    if (context != null)
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}
