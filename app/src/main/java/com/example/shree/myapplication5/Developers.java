package com.example.shree.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Developers extends AppCompatActivity {

    ListView list;
    String[] web = {
            "Pradnya Valsangkar",
            "Neha Pawar",


    } ;
    Integer[] imageId = {
            R.drawable.me,
            R.drawable.neha,



    };

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        getSupportActionBar().setTitle("Developers");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            CustomList adapter = new CustomList(Developers.this, web, imageId);
            list=(ListView)findViewById(R.id.list);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(Developers.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

                }
            });

        }

    }


