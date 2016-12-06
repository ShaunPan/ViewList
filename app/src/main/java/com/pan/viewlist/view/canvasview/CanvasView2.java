package com.pan.viewlist.view.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 */

public class CanvasView2 extends View {

    private int mHeight;
    private int mWidth;
    private Paint mPaint;


    public CanvasView2(Context context) {
        super(context);
        init();
    }

    public CanvasView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GRAY);
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

        // 移动画布至中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        Path path = new Path();
        path.lineTo(200,0);
        path.lineTo(200,200);
        path.close();
        canvas.drawPath(path,mPaint);

        mPaint.setColor(Color.BLUE);
//        canvas.scale(0.8f,0.8f);
        canvas.scale(0.8f,0.8f,100,0);
        canvas.drawPath(path,mPaint);

        RectF rectF = new RectF(0,-200,200,0);
        canvas.drawRect(rectF,mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.scale(-0.5f,-0.5f);
        canvas.drawRect(rectF,mPaint);



    }
}
