package com.example.gibo.test7;

/**
 * Created by gi bo on 2017-04-27.
 */

public class fruit {


    final static int image[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};

    String name , price;
    int imgno;
    boolean vis = false;

    public fruit(String name, int imgno){
        this.name = name;
        this.imgno = imgno;
    }


    public fruit(String name, String price ,int imgno){
        this.name = name;
        this.price = price;
        this.imgno = imgno;
    }

    public String getName(){
        return name;
    }

    public boolean getVis(){
        return vis;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setImgno(int imgno){
        this.imgno = imgno;
    }

    public void setVis(boolean vis){
        this.vis = vis;
    }

}
