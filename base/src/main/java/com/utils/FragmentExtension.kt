package com.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment


/**
 * Created by Kaz on 08:38 7/20/18
 */
fun Fragment.startActivity(clazz: Class<*>) {
    val intent = Intent(context, clazz)
    startActivity(intent)
}

fun Fragment.startActivity(clazz: Class<*>, bundle: Bundle) {
    val intent = Intent(context, clazz)
    intent.putExtras(bundle)
    startActivity(intent)
}

fun Fragment.startActivityForResult(clazz: Class<*>, requestCode: Int) {
    val intent = Intent(context, clazz)
    activity?.startActivityForResult(intent, requestCode)
}

fun Fragment.startActivityForResult(clazz: Class<*>, requestCode: Int, bundle: Bundle) {
    val intent = Intent(context, clazz)
    intent.putExtras(bundle)
    activity?.startActivityForResult(intent, requestCode)
}

fun Fragment.startActivityNewTask(clazz: Class<*>) {
    val intent = Intent(context, clazz)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    activity?.startActivity(intent)
}

fun Fragment.isConnectedInternet(): Boolean {
//    val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
//    return if (connectivityManager != null) {
//        val networkInfo = connectivityManager.activeNetworkInfo
//        networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected
//    } else {
//        false
//    }
    val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return if (connectivityManager != null) {
        val networkInfo = connectivityManager.activeNetworkInfo
        networkInfo != null && networkInfo.isConnected
    } else {
        false
    }
}
