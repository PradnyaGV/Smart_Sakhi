package com.example.shree.myapplication5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shree on 27/02/2018.
 */


public class SFMeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;
    private List<Fetch_scheme> schemeList;
    int agegroup,filter,cid;
    Button search;
    Spinner spinner1, spinner2;
    ArrayAdapter<String> adapter, adapter2;
    TextView runtime;
    String module_title="";
    String[] values = {"Filter By", "Age", "Category"};
    String[] values1 = {"0-10", "11-18", "18 Above"};
    String[] values2 = {"Health", "Education", "Employment", "Safety", "Welfare", "Finance", "Labour", "Justice", "Family"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sfme, container, false);
        getActivity().setTitle("Schemes For Me");

        search=v.findViewById(R.id.button);
        runtime=v.findViewById(R.id.runtime);
        spinner1 = (Spinner) v.findViewById(R.id.select);
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner1.setVisibility(View.VISIBLE);
        spinner2 = (Spinner) v.findViewById(R.id.selected);

        System.out.println("item::" + spinner1.getSelectedItem().toString());
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Object item = parent.getItemAtPosition(pos);
                System.out.println(item.toString());
                //prints the text in spinner item.

                if (spinner1.getSelectedItem().toString() == "Age") {
                    filter=1;
                    //System.out.println("Age selected");
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, values1);
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    spinner2.setAdapter(adapter2);
                    spinner2.setVisibility(View.VISIBLE);
                    runtime.setText("Select Agegroup");
                    runtime.setVisibility(View.VISIBLE);

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                            Object item = parent.getItemAtPosition(pos);
                            System.out.println(item.toString());
                            //prints the text in spinner item.

                            if (item.toString() == "0-10") {
                                System.out.println("age selected");
                                module_title="Schemes By Agegroup 0-10";
                                agegroup = 0;
                                search.setEnabled(true);

                            }
                            if (item.toString() == "11-18") {
                                System.out.println("age selected");
                                module_title="Schemes By Agegroup 11-18";
                                agegroup = 1;
                                search.setEnabled(true);
                            }
                            if (item.toString() == "18 Above") {
                                System.out.println("age selected");
                                module_title="Schemes By Agegroup 18 Above";
                                agegroup = 2;
                                search.setEnabled(true);
                            }
                        }

                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });


                }
                if (spinner1.getSelectedItem().toString() == "Category") {
                    filter=0;
                    System.out.println("category selected");
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, values2);
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    spinner2.setAdapter(adapter2);
                    spinner2.setVisibility(View.VISIBLE);
                    runtime.setText("Select Category");
                    runtime.setVisibility(View.VISIBLE);
                    search.setEnabled(true);


                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                            Object item = parent.getItemAtPosition(pos);
                            System.out.println(item.toString());
                            //prints the text in spinner item.

                            if (item.toString() == "Health") {
                                System.out.println("category selected");
                                module_title="Health Schemes";
                                cid = 0;
                                search.setVisibility(View.VISIBLE);

                            }
                            if (item.toString() == "Education") {
                                System.out.println("category selected");
                                module_title="Education Schemes";
                                cid = 1;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Employment") {
                                System.out.println("category selected");
                                module_title="Employment Schemes";
                                cid = 2;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Safety") {
                                System.out.println("category selected");
                                module_title="Safety Schemes";
                                cid = 3;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Welfare") {
                                System.out.println("category selected");
                                module_title="Welfare Schemes";
                                cid = 4;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Finance") {
                                System.out.println("category selected");
                                module_title="Finance Schemes";
                                cid = 5;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Labour") {
                                System.out.println("category selected");
                                module_title="Labour Schemes";
                                cid = 6;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Justice") {
                                System.out.println("category selected");
                                module_title="Justice Schemes";
                                cid = 7;
                                search.setVisibility(View.VISIBLE);
                            }
                            if (item.toString() == "Family") {
                                System.out.println("category selected");
                                module_title="Family Schemes";
                                cid = 8;
                                search.setVisibility(View.VISIBLE);
                            }
                        }

                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });



                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),HealthSchemes.class);
                i.putExtra("agegroup",agegroup);
                i.putExtra("cid",cid);
                i.putExtra("filter",filter);
                i.putExtra("module_title",module_title);
                startActivity(i);

            }
        });



        return v;
    }



}
