package com.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import com.base.R

class RoundRectCornerImageView : android.support.v7.widget.AppCompatImageView {

    private var radius = 5.0f
    private var path: Path? = null
    private var rect: RectF? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        path = Path()
        rect = RectF()
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.RoundRectCornerImageView)
            radius = typedArray.getFloat(R.styleable.RoundRectCornerImageView_radiusRound, 5.0f)
            typedArray.recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        val w = this.width
        val h = this.height

        rect?.let {
            it.left = 0f
            it.top = 0f
            it.right = w.toFloat()
            it.bottom = h.toFloat()
        }

        path?.let {
            it.addRoundRect(rect, radius, radius, Path.Direction.CW)
            canvas.clipPath(it)
        }
        super.onDraw(canvas)
    }
}
