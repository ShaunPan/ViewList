package com.pan.viewlist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.pan.viewlist.model.PieModel;

import java.util.List;

/**
 * Author: Pan
 * Date:   2016/11/26
 * Description:
 * 自定义饼状图
 * 1.初始化画笔,填充状态
 * 2.设定颜色集
 * 3.以画布中心点为圆心绘制圆
 * 4.根据数据遍历绘制弧度,使用圆心,记录绘制完毕后的角度,作为下一个弧度的起始角度
 * 5.提供设置起始角度的接口,提供设置绘制颜色的接口
 */

public class PieView extends View {

    //颜色集合
    int[] colorArr = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private static final String TAG = "PieView";

    //画笔
    private Paint anglePaint;

    //数据集合
    private List<PieModel> mPieModels;

    //默认初始角度为0度
    private float startAngle = 0;

    //延长线长度
    private float extendLine = 40;

    //文字与下划线之间距离
    private float lineDis = 10;

    //绘制区域的宽高
    private int mWidth,mHeight;

    public PieView(Context context) {
        this(context,null);

        initPaint();
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        anglePaint = new Paint();
        anglePaint.setStyle(Paint.Style.FILL);
        anglePaint.setAntiAlias(true);
        anglePaint.setTextSize(30);//默认字体大小
        anglePaint.setColor(Color.WHITE);//默认颜色
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //无数据时直接跳出
        if (mPieModels == null || mPieModels.size() == 0){
            return;
        }

        //将画布移动至中心点
        canvas.translate(mWidth / 2,mHeight / 2);

        // 圆半径
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);

        for (int j = 0; j < mPieModels.size(); j++) {

            //获取数据
            PieModel pieModel = mPieModels.get(j);
            float percentage = pieModel.getPercentage();
            String name = pieModel.getName();

            //绘制弧度
            int i = j % colorArr.length;
            anglePaint.setColor(colorArr[i]);
            RectF rectF = new RectF(-r,-r,r,r);
            canvas.drawArc(rectF,startAngle,percentage,true,anglePaint);
            startAngle += percentage;


            Log.i(TAG, "percentage: "+percentage);
            Log.i(TAG, "startAngle: "+startAngle);

            //获取新增角度的一半位置
            float halfAngle = startAngle - percentage / 2;
            Log.i(TAG, "halfAngle: "+halfAngle);

            //计算文字的起始坐标点
            float x = (float) (Math.cos(Math.toRadians(halfAngle)) * r);// Math.cos(double d)中的参数是弧度
            float y = (float) (Math.sin(Math.toRadians(halfAngle)) * r);

            //计算延长线的终点坐标
            float extendX = (float) (Math.cos(Math.toRadians(halfAngle)) * (r+extendLine));
            float extendY = (float) (Math.sin(Math.toRadians(halfAngle)) * (r+extendLine));

            //测量文字的宽度
            float dis = anglePaint.measureText(name);

            //绘制半径的延长线
            canvas.drawLine(x,y,extendX,extendY,anglePaint);

            //绘制文字和下划线
            if (halfAngle >=0 && halfAngle < 90){
                canvas.drawLine(extendX,extendY,extendX + dis,extendY,anglePaint);
                canvas.drawText(name,extendX,extendY -lineDis,anglePaint);
            }else if (halfAngle >=90 && halfAngle <180){
                canvas.drawLine(extendX,extendY,extendX - dis,extendY,anglePaint);
                canvas.drawText(name,extendX-dis,extendY -lineDis,anglePaint);
            }else if (halfAngle >=180 && halfAngle <270){
                canvas.drawLine(extendX,extendY,extendX - dis,extendY,anglePaint);
                canvas.drawText(name,extendX-dis,extendY-lineDis,anglePaint);
            }else if (halfAngle >=270 && halfAngle < 360) {
                canvas.drawLine(extendX,extendY,extendX + dis,extendY,anglePaint);
                canvas.drawText(name,extendX,extendY-lineDis,anglePaint);
            }

        }

    }

    /**
     * 填充数据
     * @param dataList 数据集合
     */
    public void fillData(List<PieModel> dataList){
        this.mPieModels = dataList;
        invalidate();
    }

    /**
     * 设置起始角度
     * @param angle 起始角度
     */
    public void setStartAngle(float angle){
        this.startAngle = angle;
        invalidate();
    }

    /**
     * 设置颜色
     * @param colorArr 颜色数组
     */
    public void setColorArr(int[] colorArr){
        this.colorArr = colorArr;
    }

    /**
     * 设置延长线长度
     * @param lineDis 延长线长度
     */
    public void setExtendLine(float lineDis){
        this.extendLine = lineDis;
    }

    /**
     * 设置下划线与文字间的间距
     * @param lineDis 下划线与文字间的间距
     */
    public void setLineDis(float lineDis){
        this.lineDis = lineDis;
    }

    public void setTextSize(float textSize){
        anglePaint.setTextSize(textSize);
    }


}
