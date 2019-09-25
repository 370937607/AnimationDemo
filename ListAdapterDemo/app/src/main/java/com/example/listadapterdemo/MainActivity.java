package com.example.listadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.frute_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        for(int i = 0;i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.fruit);
            fruitList.add(apple);
        }
    }

}
