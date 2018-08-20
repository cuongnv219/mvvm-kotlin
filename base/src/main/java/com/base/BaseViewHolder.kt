package com.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Kaz on 09:20 8/20/18
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: T)
}