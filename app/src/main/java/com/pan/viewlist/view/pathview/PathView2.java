package com.pan.viewlist.view.pathview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.pan.viewlist.R;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 */

public class PathView2 extends View {

    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;
    private Bitmap mBitmap;


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
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
//        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(5);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.stand);
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
        path.addCircle(0,0,200, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(mBitmap,-200,-200,mPaint);
        canvas.drawPath(path,mPaint);
    }
}
