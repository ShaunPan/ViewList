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
 * 基础图形绘制
 */

public class CanvasView0 extends View {

    private int mHeight;
    private int mWidth;
    private Paint mPaint;


    public CanvasView0(Context context) {
        super(context);
        init();
    }

    public CanvasView0(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 绘制颜色
        canvas.drawColor(Color.GRAY);

        // 点
        canvas.translate(mWidth/3,50);
        canvas.drawPoint(0,50,mPaint);
        canvas.translate(0,100);
        canvas.drawPoints(new float[]{10,10,30,30,50,50},mPaint);
//        canvas.translate(0,200);
//        canvas.drawPoints(new float[]{10,10,30,30,50,50},100,4,mPaint);

        // 线
        canvas.translate(0,100);
        canvas.drawLine(0,0,100,100,mPaint);
        canvas.translate(0,100);
        canvas.drawLines(new float[]{50,50,100,50,50,100,100,100},mPaint);

        // 矩形
        canvas.translate(0,150);
        mPaint.setColor(Color.BLUE);
        RectF rect = new RectF(0,0,200,100);//创建矩形对象
        canvas.drawRect(rect,mPaint);//绘制矩形对象

        // 圆角矩形
        canvas.translate(0,150);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRoundRect(rect,30,30,mPaint);//绘制矩形对象

        // 椭圆
        canvas.translate(0,150);
        mPaint.setColor(Color.WHITE);
        canvas.drawOval(rect,mPaint);

        // 圆
        canvas.translate(0,150);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(
                50,//圆心X轴的坐标
                50,//圆心Y轴的坐标
                50,//圆半径
                mPaint//画笔
        );

        // 圆弧
        canvas.translate(0,100);
        mPaint.setColor(Color.GREEN);
        canvas.drawArc(
                rect,
                0,//起始角度
                90,//结束角度
                true,//是否使用中心
                mPaint
        );

        // 文字
        canvas.translate(0,100);
        mPaint.setColor(Color.MAGENTA);
        mPaint.setTextSize(50);
        canvas.drawText("Android",//要绘制的文字
                0,//绘制文字的起始文字索引
                7,//绘制文字的结束文字索引
                0,//绘制起始X坐标
                50,//绘制起始Y坐标,当Y坐标的值偏小时,会导致文字显示部分的问题
                mPaint);

        canvas.translate(0,100);
        mPaint.setTextSize(10);
        mPaint.setColor(Color.DKGRAY);
        Path path = new Path();
        path.lineTo(50,60);
        path.lineTo(100,80);
        path.lineTo(10,10);
        canvas.drawTextOnPath("AndroidAndroidAndroidAndroidAndroidAndroid",path,10,10,mPaint);

    }
}
