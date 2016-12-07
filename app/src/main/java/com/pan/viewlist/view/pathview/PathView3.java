package com.pan.viewlist.view.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 */

public class PathView3 extends View {

    private static final String TAG = "PathView3";
    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;


    public PathView3(Context context) {
        super(context);
        init();
    }

    public PathView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView3(Context context, AttributeSet attrs, int defStyleAttr) {
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
        RectF rectF = new RectF(0,0,100,100);
        path.addRect(rectF, Path.Direction.CW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.i(TAG, "isConvex: "+path.isConvex());
        }
        Log.i(TAG, "isEmpty: "+path.isEmpty());
        Log.i(TAG, "isRect: "+path.isRect(rectF));

        Path linePath = new Path();
        linePath.lineTo(100,100);
        path.set(linePath);// 等价于替换path

        canvas.drawPath(path,mPaint);

        canvas.translate(200,0);
        Path destPath = new Path();// 目标路径,用于存储偏移后的路径
        path.offset(200,0,destPath);

        mPaint.setColor(Color.RED);
        canvas.drawPath(path,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawPath(destPath,mPaint);



    }
}
