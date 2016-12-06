package com.pan.viewlist.view.pathview;

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

public class PathView1 extends View {

    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;


    public PathView1(Context context) {
        super(context);
        init();
    }

    public PathView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
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

        canvas.translate(mCenterX,mCenterY);
        Path path = new Path();
        path.lineTo(200,200);
        path.moveTo(100,100);
        path.lineTo(100,0);
        path.setLastPoint(50,0);
        path.close();
        canvas.drawPath(path,mPaint);
    }
}
