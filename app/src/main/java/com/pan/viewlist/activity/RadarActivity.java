package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pan.viewlist.R;

/**
 * Author: Pan
 * Date:   2016/12/4
 * Description:
 */

public class RadarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);


    }

    public static Intent createIntent(Context context) {
        return new Intent(context,RadarActivity.class);
    }
}
