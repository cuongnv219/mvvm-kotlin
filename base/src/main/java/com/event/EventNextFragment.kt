package com.event

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by Kaz on 14:56 8/20/18
 */
class EventNextFragment {

    var clazz: Class<Fragment>? = null
    var bundle: Bundle? = null
    var isAddToBackStack: Boolean = false

    constructor(clazz: Class<Fragment>, bundle: Bundle, addToBackStack: Boolean) {
        this.clazz = clazz
        this.bundle = bundle
        this.isAddToBackStack = addToBackStack
    }

    constructor(clazz: Class<Fragment>, addToBackStack: Boolean) {
        this.clazz = clazz
        this.isAddToBackStack = addToBackStack
    }
}