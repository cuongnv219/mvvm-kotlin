package com.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundRectCornerImageView extends android.support.v7.widget.AppCompatImageView {

    private float radius = 5.0f;
    private Path path;
    private RectF rect;

    public RoundRectCornerImageView(Context context) {
        super(context);
        init();
    }

    public RoundRectCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundRectCornerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        path = new Path();
        rect = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = this.getWidth();
        int h = this.getHeight();
        rect.left = 0;
        rect.top = 0;
        rect.right = w;
        rect.bottom = h;

        path.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
