package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pan.viewlist.R;

/**
 * Author: Pan
 * Date:   2016/12/6
 * Description:
 * 画布操作之scale
 */

public class CanvasView2Activity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, CanvasView2Activity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_view_2);

        setTitle(R.string.canvas_view_2);
    }


}
