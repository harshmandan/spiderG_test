package com.danman.harsh.spidergtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

// Because of use of no threads, app might run sluggish on some devices

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;                  //Create new toolbar and listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                     //set layout
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tool_title);      //set toolbar title
        listView = (ListView) findViewById(R.id.listView);
        final String[] vidid = getResources().getStringArray(R.array.videos);
        final String[] vidname = getResources().getStringArray(R.array.showlist);       //string to hold video id and names
        Rock_thumb_adap rockAdapter = new Rock_thumb_adap (MainActivity.this, getResources().getStringArray(R.array.showlist), getResources().getStringArray(R.array.videos));
        listView.setAdapter(rockAdapter);       //set newly created custom adapter in listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bundle send = new Bundle();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                send.putString("TOOL_TITLE", vidname[position]);
                send.putString("VID_ID", vidid[position]);  //put title and vid id in a bundle
                intent.putExtras(send);// send bundle to the next activity
                startActivity(intent);
            }
        });
    }
}
