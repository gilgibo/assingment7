package com.example.gibo.test7;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<fruit> fruit = new ArrayList<fruit>();
    ArrayList<String> cart = new ArrayList<String>();
    int imglist[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};
    GridAdapter adapter;
    GridView gridView;
    addfruit addFruit;
    CheckBox cbprice;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gridView = (GridView)findViewById(R.id.grid);
        addFruit = (addfruit)findViewById(R.id.add);
        cbprice = (CheckBox)findViewById(R.id.cbprice);
        bt = (Button)findViewById(R.id.bt);

        adapter = new GridAdapter(this, fruit);
        gridView.setAdapter(adapter);

        addFruit.setOnAddListener(new addfruit.OnAddListener() {
            @Override
            public void onAdd(String name, String price ,int imageno) {
                fruit.add(new fruit( name, price ,imageno));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChange(int position, String name, String price, int imageno) {
                fruit.get(position).setName(name);
                fruit.get(position).setPrice(price);
                fruit.get(position).setImgno(imageno);
                adapter.notifyDataSetChanged();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Main2Activity.this);
                dlg.setTitle("선택").setMessage("카트 담기 혹은 변경중 하나를 선택하세요").setPositiveButton("카트 담기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), position+1 +" 번째 " + fruit.get(position).getName() + "이(가) 카트에 담겼습니다.", Toast.LENGTH_SHORT).show();
                        cart.add(fruit.get(position).getName());
                    }
                }).setNegativeButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), position+1 +" 번째 " + fruit.get(position).getName() + "이(가) 선택 되었습니다.", Toast.LENGTH_SHORT).show();
                        addFruit.setPosition(position);
                        adapter.notifyDataSetChanged();
                    }
                }).show();
            }
        });

        priceVis();

    }

    public  void priceVis(){
        cbprice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    for(int i = 0 ; i < fruit.size() ; i ++){
                        fruit.get(i).setVis(true);
                    }
                } else{
                    for(int i = 0 ; i < fruit.size() ; i ++){
                        fruit.get(i).setVis(false);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void onClick(View v){
        if(v.getId() == R.id.bt){
            String list = "";
            for(int i = 0 ; i < cart.size() ; i++) {
                if(!list.contains(cart.get(i)))
                    list = list + cart.get(i)+ " ";
            }
            Toast.makeText(getApplicationContext(),list, Toast.LENGTH_SHORT).show();
        }
    }
}
