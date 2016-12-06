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

public class PathActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] itemName = {"moveTo,lineTo,setLastPoint,close","addXxx与arcTo","isEmpty、isRect、isConvex、set和offset"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.path);

        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,itemName));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(PathView1Activity.createIntent(PathActivity.this));
                        break;
                    case 1:
                        startActivity(PathView2Activity.createIntent(PathActivity.this));
                        break;
                    case 2:

                        break;
                    default:
                        break;
                }
            }
        });

    }

    public static Intent createIntent(Context context) {
        return new Intent(context,PathActivity.class);
    }
}
