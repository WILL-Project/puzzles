package com.pizzle.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    String[] Name = {"Mango","Milk","Mushroom","Pear","Pineapple","Strawberry","Water","Watermelon"};
    int[] Images = {R.drawable.mango,R.drawable.milk,R.drawable.mushrooms,R.drawable.pear,R.drawable.pineapple,
            R.drawable.strawberry,R.drawable.water,R.drawable.watermelon};
    Button btnpz;
    ArrayList<puzzelCheck> pCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pCheck = new ArrayList<puzzelCheck>(getIntent().getIntExtra("arraylist",0));


        gridView = findViewById(R.id.gridview);
        CustAdapterGallary custAdapterGallary = new CustAdapterGallary();

        gridView.setAdapter(custAdapterGallary);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), puzzleActivity.class);

                if(pCheck != null){
                    intent.putExtra("arraylist", pCheck);

                }
                intent.putExtra("Position" , position);

                intent.putExtra("img",0);

                startActivity(intent);
            }
        });
    }private  class CustAdapterGallary extends BaseAdapter {


        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.data, null);
            TextView name = view.findViewById(R.id.name);
            ImageView imageView = view.findViewById(R.id.images);

            name.setText(Name[position]);
            imageView.setImageResource(Images[position]);




            return view;
        }
    }



}
