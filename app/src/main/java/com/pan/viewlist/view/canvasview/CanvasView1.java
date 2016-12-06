package com.pan.viewlist.view.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 */

public class CanvasView1 extends View {

    private int mHeight;
    private int mWidth;
    private Paint mPaint;


    public CanvasView1(Context context) {
        super(context);
        init();
    }

    public CanvasView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0,0,100,100,mPaint);

        // 移动画布至中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        mPaint.setColor(Color.BLUE);
        canvas.drawLine(0,0,100,100,mPaint);
    }
}
