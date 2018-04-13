package com.example.shree.myapplication5;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchemeDetails extends AppCompatActivity implements TextToSpeech.OnInitListener{

    String schemeTitle,s_desc,s_title;
    private List<Fetch_Scheme_Details> schemeList;
    int cid, sid;
    TextView title, desc, dol, eligibility, benefits, howtoapply;
    TextView label1,label2,label3,label4;
    TextToSpeech tts;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        p=findViewById(R.id.progressBar);

        title = findViewById(R.id.title_id);
        desc = findViewById(R.id.description_id);
        dol = findViewById(R.id.DOL_id);
        tts = new TextToSpeech(this, this);

        benefits = findViewById(R.id.benefits_id);
        howtoapply = findViewById(R.id.howtoapply_id);

        label1=findViewById(R.id.description);
        label2=findViewById(R.id.DOL);
        label3=findViewById(R.id.eligibility);
        label4=findViewById(R.id.howtoapp);

        Intent i = getIntent();
        schemeTitle = i.getStringExtra("title");
        cid = i.getIntExtra("cid", 0);
        sid = i.getIntExtra("sid", 0);

        //Toast.makeText(getApplicationContext(), "Hiiiiiiiiiii I am Pradnya "+cid+"  "+sid, Toast.LENGTH_LONG).show();

        link_scheme_details();


    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.share_scheme)
        {
            if(s_title!=null || s_desc!=null) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, s_title + "\n\n\n" + s_desc);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
            else
                Toast.makeText(this,"Data is unavailable",Toast.LENGTH_LONG).show();

        }

        if(id==R.id.screen_reader)
        {
            if(s_desc!=null)
                sp();
            else
                Toast.makeText(this,"Data is unavailable",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                System.out.println("TTS : " + "This Language is not supported");
            } else {
                //btnSpeak.setEnabled(true);
                sp();
            }

        } else {
            System.out.println("TTS : " + "Initilization Failed!");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public void sp() {
        String t = label1.getText().toString();


        tts.speak(s_desc, TextToSpeech.QUEUE_FLUSH, null);
    }

    protected void link_scheme_details() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://smart-sakhi.000webhostapp.com").addConverterFactory(GsonConverterFactory.create()).build();
        System.out.println("hey " + retrofit.toString());
        APiService service = retrofit.create(APiService.class);

        Call<List<Fetch_Scheme_Details>> call = service.getSchemeDetails(cid,sid);
        Log.d("retrofit", call + "");

        call.enqueue(new Callback<List<Fetch_Scheme_Details>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Fetch_Scheme_Details>> call, Response<List<Fetch_Scheme_Details>> response) {
                System.out.println("Response body " + response.body());
                List<Fetch_Scheme_Details> list = response.body();
                if(list!=null)
                    p.setVisibility(View.GONE);
                Fetch_Scheme_Details s = null;
                System.out.println("list Size" + list + "");
                System.out.println("sid:" + sid);
                s = new Fetch_Scheme_Details();
                s_title = list.get(0).getTitle();
                s.setTitle(s_title);
                System.out.println("Data is added as " + s_title);
                s_desc = list.get(0).getDescription();
                s.setTitle(s_desc);
                String s_dol = list.get(0).getDOLaunch();
                System.out.println("Date " + s_dol);
                s.setTitle(s_dol);
                String s_eli = list.get(0).getEligibility();
                s.setTitle(s_eli);
                System.out.println("eligibility :" + s_eli);
                String s_ben = list.get(0).getBenefits();
                s.setTitle(s_ben);
                System.out.println("benefits " + s_ben);
                String s_how = list.get(0).getHowtoapply();
                s.setTitle(s_how);

                //schemeList.add(s);
                System.out.println("how :" + s_how);


                label1.setVisibility(View.VISIBLE);
                label2.setVisibility(View.VISIBLE);
                label3.setVisibility(View.VISIBLE);
                label4.setVisibility(View.VISIBLE);

                title.setText(s_title);
                desc.setText(s_desc);
                desc.setMovementMethod(ScrollingMovementMethod.getInstance());
                dol.setText(s_dol);
                benefits.setText(s_eli);
                //eligibility.setText(s_eli);
                howtoapply.setText(s_how);


            }

            @Override
            public void onFailure(retrofit2.Call<List<Fetch_Scheme_Details>> call, Throwable t) {

            }
        });


        Fetch_Scheme_Details f = new Fetch_Scheme_Details();
        f.setTitle(schemeTitle);

        title.setText(schemeTitle);


    }
}
