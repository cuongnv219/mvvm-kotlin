package com.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by Kaz on 08:29 7/20/18
 */
fun Activity.startActivity(clazz: Class<*>) {
    val intent = Intent(this, clazz)
    startActivity(intent)
}

fun Activity.startActivity(clazz: Class<*>, bundle: Bundle) {
    val intent = Intent(this, clazz)
    intent.putExtras(bundle)
    startActivity(intent)
}

fun Activity.startActivityForResult(clazz: Class<*>, requestCode: Int) {
    val intent = Intent(this, clazz)
    startActivityForResult(intent, requestCode)
}

fun Activity.startActivityForResult(clazz: Class<*>, requestCode: Int, bundle: Bundle) {
    val intent = Intent(this, clazz)
    intent.putExtras(bundle)
    startActivityForResult(intent, requestCode)
}

fun Activity.startActivityNewTask(clazz: Class<*>) {
    val intent = Intent(this, clazz)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(intent)
}