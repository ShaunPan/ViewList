package com.pan.viewlist.view.Paintview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Author: Pan
 * Date:   2016/12/8
 * Description:
 */

public class PaintView1 extends View {

    private Paint mDefaultPaint;
    private Paint mOtherPaint;
    private static final String TAG = "PaintView1";

    public PaintView1(Context context) {
        super(context);
        init();
    }

    public PaintView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init() {
        mDefaultPaint = new Paint();
        mDefaultPaint.setColor(Color.GRAY);
        mDefaultPaint.setTextAlign(Paint.Align.LEFT);
        mDefaultPaint.setTextSize(50);

        mOtherPaint = new Paint();
        mOtherPaint.setColor(Color.RED);
        mOtherPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        String text = "test text";
        float textW = mDefaultPaint.measureText(text);
        Paint.FontMetrics fontMetrics = mDefaultPaint.getFontMetrics();
        float ascent = fontMetrics.ascent;
        float bottom = fontMetrics.bottom;
        float descent = fontMetrics.descent;
        float leading = fontMetrics.leading;
        float top = fontMetrics.top;

        Log.i(TAG, "textW: "+textW);
        Log.i(TAG, "ascent: "+ascent);
        Log.i(TAG, "bottom: "+bottom);
        Log.i(TAG, "descent: "+descent);
        Log.i(TAG, "leading: "+leading);
        Log.i(TAG, "top: "+top);
        Log.i(TAG, "textH: "+ (descent - ascent));

        Path linePath = new Path();
        linePath.lineTo(100,100);
        linePath.rLineTo(textW,0);
        canvas.drawPath(linePath,mOtherPaint);
        canvas.drawText(text,100,100,mDefaultPaint);
    }
}
