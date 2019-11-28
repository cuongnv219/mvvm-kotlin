package com.base

import androidx.recyclerview.widget.RecyclerView
import android.view.View

/**
 * Created by Kaz on 09:20 8/20/18
 */
abstract class BaseViewHolder<T>(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: T)
}