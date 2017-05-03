package com.example.gibo.test7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gi bo on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<fruit> fruit;

    public GridAdapter( Context context, ArrayList<fruit> fruit){
        this.context = context;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//       if(convertView == null)
//            convertView = LayoutInflater.from(context).inflate(R.layout.gridviewitem, null);
//
//        final TextView tv = (TextView)convertView.findViewById(R.id.tvname);
//        final ImageView img = (ImageView)convertView.findViewById(R.id.img1);
//
//        tv.setText(fruit.get(position).name);
//        img.setImageResource(fruit.get(position).imgno);

        if(convertView == null)
             convertView = new GridItem(context);
        ((GridItem)convertView).setData(fruit.get(position));



        if(fruit.size() != 0){
            for( int i = 0 ; i < fruit.size() ; i ++){
                if(fruit.get(i).getVis() == true)
                    ((GridItem)convertView).pVisible();
                else
                    ((GridItem)convertView).pInvisible();
            }
        }
        return convertView;
    }

}
