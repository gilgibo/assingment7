package com.example.gibo.test7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gi bo on 2017-04-27.
 */

public class GridItem extends LinearLayout {


    TextView tv, tvprice;
    ImageView img;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){

        View view = LayoutInflater.from(context).inflate(R.layout.gridviewitem, this);

        tv = (TextView)view.findViewById(R.id.tvname);
        tvprice = (TextView)view.findViewById(R.id.tvprice);
        img = (ImageView)view.findViewById(R.id.img1);

    }

    public void setData(fruit me){
        tv.setText(me.name);
        tvprice.setText(me.price);
        img.setImageResource(me.imgno);
    }

    public void pVisible(){
        tvprice.setVisibility(VISIBLE);
    }

    public void pInvisible(){
        tvprice.setVisibility(INVISIBLE);
    }


}
