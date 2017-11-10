package com.example.recyclertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PersoInfoActivity extends AppCompatActivity {

    private ListView mListView;

    private List<String> options = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        mListView = (ListView) findViewById(R.id.option_list);
        initOptions();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        mListView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Bar);
        setSupportActionBar(toolbar);
    }

    private void initOptions() {
        Option option1 = new Option();
        option1.setOptionName("基本信息");
        options.add(option1.getOptionName());
        Option option2 = new Option();
        option2.setOptionName("安全信息");
        options.add(option2.getOptionName());
    }
}
