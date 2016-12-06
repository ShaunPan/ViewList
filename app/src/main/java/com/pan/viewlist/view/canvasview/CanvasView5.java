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

public class CanvasView5 extends View {

    private int mHeight;
    private int mWidth;
    private Paint mPaint;


    public CanvasView5(Context context) {
        super(context);
        init();
    }

    public CanvasView5(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView5(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
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

        canvas.save();// 创建图层1,画红色三角形,此时原点为(0,0)
        // 绘制三角形路径
        Path path = new Path();
        path.lineTo(200, 0);
        path.lineTo(200, 200);
        path.close();
        canvas.drawPath(path, mPaint);

        canvas.save();// 创建图层2,画灰色三角形,此时原点为(mWidth / 2, mHeight / 2)
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.rotate(30);
        mPaint.setColor(Color.GRAY);
        canvas.drawPath(path, mPaint);
        canvas.restore();//返回图层1状态,并不会影响已绘制的灰色图形

        // 在图层1的状态下绘制黑色三角形
        canvas.rotate(30);
        mPaint.setColor(Color.BLACK);
        canvas.drawPath(path,mPaint);
    }
}
