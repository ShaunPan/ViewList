package com.pan.viewlist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
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

    private Paint anglePaint;
    //数据集合
    private List<PieModel> mPieModels;
    //默认初始角度为0度
    private float startAngle = 0;

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
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mPieModels == null || mPieModels.size() == 0){
            return;
        }


        // 圆半径
        float c = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);

        canvas.translate(mWidth / 2,mHeight / 2);

        /* 根据数据绘制弧度 */
        for (int j = 0; j < mPieModels.size(); j++) {

            PieModel pieModel = mPieModels.get(j);
            float percentage = pieModel.getPercentage();

            int i = j % colorArr.length;
            anglePaint.setColor(colorArr[i]);
            RectF rectF = new RectF(-c,-c,c,c);
            canvas.drawArc(rectF,startAngle,percentage,true,anglePaint);
            startAngle += percentage;
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

    public void setStartAngle(float angle){
        this.startAngle = angle;
        invalidate();
    }

    public void setColorArr(int[] colorArr){
        this.colorArr = colorArr;
    }

}
