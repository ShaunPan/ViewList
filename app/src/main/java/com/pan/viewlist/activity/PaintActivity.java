package com.pan.viewlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pan.viewlist.R;

public class PaintActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] itemName = {"基础设置","文字设置", "效果设置", "图片设置"};

    public static Intent createIntent(Context context) {
        return new Intent(context, PaintActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.paint);

        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemName));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(PaintView1Activity.createIntent(PaintActivity.this));
                        break;
                    case 1:
                        startActivity(CanvasView1Activity.createIntent(PaintActivity.this));
                        break;
                    case 2:
                        startActivity(CanvasView2Activity.createIntent(PaintActivity.this));
                        break;
                    case 3:
                        startActivity(CanvasView3Activity.createIntent(PaintActivity.this));
                        break;
                    case 4:
                        startActivity(CanvasView4Activity.createIntent(PaintActivity.this));
                        break;
                    case 5:
                        startActivity(CanvasView5Activity.createIntent(PaintActivity.this));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
