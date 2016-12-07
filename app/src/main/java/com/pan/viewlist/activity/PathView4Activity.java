package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pan.viewlist.R;

public class PathView4Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_view_4);

        setTitle(R.string.path_view_4);

    }

    public static Intent createIntent(Context context) {
        return new Intent(context,PathView4Activity.class);
    }
}
