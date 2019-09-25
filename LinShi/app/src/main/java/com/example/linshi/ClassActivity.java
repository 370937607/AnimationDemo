package com.example.linshi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClassActivity extends AppCompatActivity {
    private String[] data = { "java", "安卓", "语文", "数学",
             "政治", "英语", "历史" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ClassActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
