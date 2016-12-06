package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pan.viewlist.R;
import com.pan.viewlist.view.pathview.PathView1;

public class PathView1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_view_1);

        setTitle(R.string.path_view_1);

        PathView1 pathView1 = (PathView1) findViewById(R.id.pathView1);

    }

    public static Intent createIntent(Context context) {
        return new Intent(context,PathView1Activity.class);
    }
}
