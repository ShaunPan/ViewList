package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pan.viewlist.R;
import com.pan.viewlist.model.PieModel;
import com.pan.viewlist.view.PieView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 */

public class PieActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context,PieActivity.class);
    }

    public int[] colorArr={0xFFCCFF00, 0xFF6495ED,0xFFFFFFFF,0xFF000000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        setTitle(R.string.pie_view);

        PieView pieView = (PieView) findViewById(R.id.pieView);
        // 设置饼状图起始角度
        pieView.setStartAngle(90);
        // 填充数据
        pieView.fillData(createData(10));
        // 设置饼状图颜色
        // pieView.setColorArr(colorArr);
    }


    /**
     * 创建测试数据
     * @return 测试数据
     */
    private List<PieModel> createData(int dataListSize) {

        // 数据统计
        float dataCount = 0;

        List<PieModel> pieModelList = new ArrayList<>();

        for (int i =0;i < dataListSize;i++){
            float value = (i+1)*2;
            PieModel pie = new PieModel();
            pie.setValue(value);
            pieModelList.add(pie);
        }

        for (int i = 0; i < pieModelList.size(); i++){
            PieModel pieModel = pieModelList.get(i);
            float value = pieModel.getValue();
            dataCount += value;
        }

        for (int i = 0; i < pieModelList.size(); i++){
            PieModel pieModel = pieModelList.get(i);
            float value = pieModel.getValue();
            pieModel.setPercentage(value / dataCount * 360);
        }

        return pieModelList;
    }


}
