package com.pan.viewlist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pan.viewlist.R;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] itemName = {"Canvas","Path","RadarView","PieView"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemName));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(CanvasActivity.createIntent(MainActivity.this));
                        break;
                    case 1:
                        startActivity(PathActivity.createIntent(MainActivity.this));
                        break;
                    case 2:
                        startActivity(RadarActivity.createIntent(MainActivity.this));
                        break;
                    case 3:
                        startActivity(PieActivity.createIntent(MainActivity.this));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
