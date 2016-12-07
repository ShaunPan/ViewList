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

public class PathView4 extends View {

    private static final String TAG = "PathView4";
    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;


    public PathView4(Context context) {
        super(context);
        init();
    }

    public PathView4(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView4(Context context, AttributeSet attrs, int defStyleAttr) {
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

        canvas.translate(100,100);
        Path path = new Path();
        path.lineTo(100,100);
        path.lineTo(200,200);

        // 重置后将移除上面的线路径
        path.reset();
        RectF rectF = new RectF(0,0,100,100);
        path.addRect(rectF, Path.Direction.CW);
        mPaint.setColor(Color.RED);
        canvas.drawPath(path,mPaint);

        // 已绘制的path不会从canvas上移除,只是移除了path中存储的路径
        path.reset();
        canvas.translate(mCenterX,mCenterY);
        canvas.scale(1,-1);
        path.lineTo(50,100);
        mPaint.setColor(Color.MAGENTA);
        path.rLineTo(100,100);
        canvas.drawPath(path,mPaint);

        RectF boundsRect = new RectF();
        path.computeBounds(boundsRect,true);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(boundsRect,mPaint);

    }
}
