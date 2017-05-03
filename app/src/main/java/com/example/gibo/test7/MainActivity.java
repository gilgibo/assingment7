package com.example.gibo.test7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner spinner;
    String[] fruit = {"사과", "복숭아","포도"};
    SpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = new SpinnerAdapter(this,fruit);
        spinner.setAdapter(adapter);

    }
}
