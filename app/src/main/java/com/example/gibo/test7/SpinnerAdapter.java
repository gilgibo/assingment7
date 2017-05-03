package com.example.gibo.test7;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by gi bo on 2017-04-27.
 */

public class SpinnerAdapter extends BaseAdapter {

    String[] fruit ;
    Context context;

    public SpinnerAdapter(Context context, String[] fruit){
        this.context = context;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int position) {return fruit[position];}

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.spinneritem, null);

        final TextView tv = (TextView)convertView.findViewById(R.id.textView);
        final CheckBox cb = (CheckBox)convertView.findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = "선택되었습니다.";
                if(isChecked) msg = "선택되지 않았습니다.";
            }
        });
        tv.setText(fruit[position]);
        return convertView;
    }
}
