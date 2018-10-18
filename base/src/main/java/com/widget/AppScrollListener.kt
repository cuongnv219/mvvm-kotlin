package com.widget

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class AppScrollListener : RecyclerView.OnScrollListener() {
    private var lastCompletelyVisibleItemPosition: Int = 0
    private var firstVisibleItemPosition: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val layoutManager = recyclerView.layoutManager
        val size = layoutManager!!.itemCount
        if (layoutManager is LinearLayoutManager) {
            findFirstAndLastVisible(layoutManager)
        }

        if (dy > 0 && size - lastCompletelyVisibleItemPosition <= 4) {
            onLoadMore()
        }
    }

    private fun findFirstAndLastVisible(layoutManager: LinearLayoutManager) {
        firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        lastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()
    }

    abstract fun onLoadMore()
}
