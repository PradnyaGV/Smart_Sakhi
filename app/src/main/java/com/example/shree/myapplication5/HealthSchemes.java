package com.example.shree.myapplication5;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

public class HealthSchemes extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;
    private List<Fetch_scheme> schemeList;
    //Bundle id;
    int sid,cid,filter,catid,agegroup,forwomen,isnew;
    ProgressBar p;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schemes_recycler_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        p=findViewById(R.id.progress);

        Intent i = getIntent();
        filter=i.getIntExtra("filter",0);
        System.out.println("Filter :"+filter);
        agegroup=i.getIntExtra("agegroup",0);
        System.out.println("Agegroup :"+agegroup);

        setTitle(i.getStringExtra("module_title"));
        cid= i.getIntExtra("cid",0);
        System.out.print("Category received : " + cid);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        schemeList = new ArrayList<>();
        moduleAdapter = new ModuleAdapter(this, schemeList, cid);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(moduleAdapter);
        prepareModules();

    }

    private void prepareModules() {
        Log.d("prepareModules", "inside");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://smart-sakhi.000webhostapp.com").addConverterFactory(GsonConverterFactory.create()).build();
        System.out.println("hey " + retrofit.toString());
        APiService service = retrofit.create(APiService.class);
        Call<List<Fetch_scheme>> call;
        if (filter==1) {
            call = service.getTransationDetailsFilter(agegroup + 1);
        }
        else{
            call = service.getTransationDetails(cid + 1);
        }

        Log.d("retrofit", call + "");

        call.enqueue(new Callback<List<Fetch_scheme>>() {
            @Override
            public void onResponse(Call<List<Fetch_scheme>> call, Response<List<Fetch_scheme>> response) {
                List<Fetch_scheme> list = response.body();
                if(list!=null)
                    p.setVisibility(View.GONE);
                Fetch_scheme s = null;
                System.out.println("list Size" + list + "");
                for (int i = 0; i < list.size(); i++) {
                    s = new Fetch_scheme();
                    String transaction_id = list.get(i).getTitle();
                    s.setTitle(transaction_id);
                    sid = list.get(i).getSid();
                    s.setSid(sid);
                    catid=list.get(i).getCatid();
                    s.setCatid(catid);
                    forwomen=list.get(i).getForwomen();
                    s.setForwomen(forwomen);
                    isnew=list.get(i).getIsnew();
                    s.setIsnew(isnew);
                    System.out.println("fetched catid:--"+catid);
                    System.out.println("for women"+forwomen);
                    System.out.println("Data is added as " + transaction_id);
                    schemeList.add(s);
                    System.out.println("printed");
                }
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(HealthSchemes.this, 1); //changed from 2 to 1
                recyclerView.setLayoutManager(mLayoutManager);

                moduleAdapter = new ModuleAdapter(getApplicationContext(), schemeList, cid);
                recyclerView.setAdapter(moduleAdapter);
            }

            @Override
            public void onFailure(Call<List<Fetch_scheme>> call, Throwable t) {

            }


        });


    }


}
