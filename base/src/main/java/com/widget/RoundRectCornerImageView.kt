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
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundRectCornerImageView)
            radius = typedArray.getFloat(R.styleable.RoundRectCornerImageView_radiusRound, 5.0f)
            typedArray.recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        val w = this.width
        val h = this.height
        rect!!.left = 0f
        rect!!.top = 0f
        rect!!.right = w.toFloat()
        rect!!.bottom = h.toFloat()

        path!!.addRoundRect(rect, radius, radius, Path.Direction.CW)
        canvas.clipPath(path!!)
        super.onDraw(canvas)
    }
}
