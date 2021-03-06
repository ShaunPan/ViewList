package com.pan.viewlist.view.pathview;

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

public class PathView2 extends View {

    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;


    public PathView2(Context context) {
        super(context);
        init();
    }

    public PathView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mCenterX = w / 2;
        this.mCenterY = h / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.translate(200,200);
        Path path = new Path();
        RectF rectF = new RectF(0,0,100,100);
        path.addRect(rectF, Path.Direction.CW);
        canvas.drawPath(path,mPaint);

        canvas.translate(200,0);
        // 圆弧起点不与终点连接,等价于addArc (RectF oval, float startAngle, float sweepAngle)
        path.arcTo(rectF,0,100,true);
        mPaint.setColor(Color.RED);
        canvas.drawPath(path,mPaint);

        canvas.translate(200,0);
        // 圆弧起点与终点连接,等价于arcTo (RectF oval, float startAngle, float sweepAngle)
        path.arcTo(rectF,0,100,false);
        mPaint.setColor(Color.BLUE);
        canvas.drawPath(path,mPaint);

    }
}
