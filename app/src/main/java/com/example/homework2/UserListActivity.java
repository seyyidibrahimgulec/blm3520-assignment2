package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class UserListActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private String current_key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ArrayList<String> keys = new ArrayList<>();


        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Map<String, ?> allEntries = preferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            current_key = entry.getKey();
            if(!current_key.equals("reply") && !current_key.equals("sync"))
                keys.add(entry.getKey());

        }

        ListView list = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> dataAdaptor=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, keys);

        list.setAdapter(dataAdaptor);

    }
}
