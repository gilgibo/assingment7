package com.example.gibo.test7;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by gi bo on 2017-04-27.
 */

public class addfruit extends LinearLayout implements View.OnClickListener{
    int imgno = 0;
    int position = 0;
    EditText etprice;
    AutoCompleteTextView etname;
    ImageView img;
    Button b_next, b_add;
    String[] name = {"abocado", "banana", "cherry",
            "cranberry", "grape", "kiwi",
            "orange", "watermelon"};
    ArrayAdapter<String> adapter;


    public addfruit(Context context, AttributeSet attris) {
        super(context,attris);
        init(context);
    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruitadd, this);
        etname = (AutoCompleteTextView)findViewById(R.id.f_name);
        etprice = (EditText)findViewById(R.id.f_price);
        img = (ImageView)findViewById(R.id.image1);
        b_add = (Button)findViewById(R.id.b_add);
        b_next = (Button)findViewById(R.id.b_next);
        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);

        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, name);
        etname.setAdapter(adapter);
    }

    public void onClick(View v){
        if(v == b_add && b_add.getText().equals("ADD")){
            onAddListener.onAdd(etname.getText().toString(), etprice.getText().toString() , fruit.image[imgno]);
        }else if(v == b_add && b_add.getText().equals("M")){
            b_add.setText("ADD");
            onAddListener.onChange(position,etname.getText().toString(), etprice.getText().toString() , fruit.image[imgno]);
        }else if( v == b_next ){
            imgno = (imgno + 1) % fruit.image.length;
            img.setImageResource(fruit.image[imgno]);
        }
    }

    interface OnAddListener{
        void onAdd(String name, String price , int imageno);
        void onChange(int position ,String name, String price , int imageno);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }

    public void setPosition(int position){
        b_add.setText("M");
        this.position = position;
    }


}
