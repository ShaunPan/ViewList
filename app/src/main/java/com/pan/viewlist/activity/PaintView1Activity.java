package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pan.viewlist.R;

public class PaintView1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_view_1);

        setTitle(R.string.paint_view_1);

    }

    public static Intent createIntent(Context context) {
        return new Intent(context,PaintView1Activity.class);
    }
}
