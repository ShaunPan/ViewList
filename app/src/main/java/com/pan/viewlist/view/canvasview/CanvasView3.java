package com.pan.viewlist.view.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 */

public class CanvasView3 extends View {

    private int mHeight;
    private int mWidth;
    private Paint mPaint;


    public CanvasView3(Context context) {
        super(context);
        init();
    }

    public CanvasView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 移动画布至中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        // 绘制三角形路径
        Path path = new Path();
        path.lineTo(200, 0);
        path.lineTo(200, 200);
        path.close();

        // 循环绘制三角形并进行偏移旋转
        for (int i = 0; i < 4; i++) {
            canvas.rotate(90,100,0);// 以(100,0)这个点为旋转中心进行旋转
            canvas.drawPath(path, mPaint);
        }

    }
}
