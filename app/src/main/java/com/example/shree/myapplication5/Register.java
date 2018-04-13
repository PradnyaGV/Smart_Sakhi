package com.example.shree.myapplication5;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class Register extends AppCompatActivity {
    Integer ageno;
    EditText fname, lname, username, contact, profession, password, age,confirmpass;
    String a=null, b=null, c=null, d=null, e=null, f=null, g=null;
    String duppass;
boolean flag=false;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg = findViewById(R.id.register);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(getApplicationContext(), "Connected ", Toast.LENGTH_LONG).show();
        } else {
            reg.setEnabled(false);
        }
        fname = (EditText) findViewById(R.id.firstname);
        lname = (EditText) findViewById(R.id.lastname);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Pass);
        confirmpass=(EditText) findViewById(R.id.ConfirmPass);
        contact = (EditText) findViewById(R.id.mobno);
        profession = (EditText) findViewById(R.id.profession);
        age = (EditText) findViewById(R.id.age);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUser();
            }
        });

    }

    protected void RegisterUser() {
        a = fname.getText().toString();
        if(a.length()==0)
        {
            fname.setHint("Enter your first name");
        }
        b = lname.getText().toString();
        if(b.length()==0)
        {
            lname.setHint("Enter your last name");
        }
        c = username.getText().toString();
        if(c.length()==0)
        {
            username.setHint("Enter username");
        }
        d = password.getText().toString();
        if(d.length()==0)
        {
            password.setHint("Enter password");
        }
        duppass=confirmpass.getText().toString();
        if(!d.equals(duppass))
        {
            confirmpass.setText("");
            duppass="";
            confirmpass.setHint("Confirm your password");
        }
        if(confirmpass.getText().toString()==null)
        {
            confirmpass.setHint("Re-enter password");
        }
        e = profession.getText().toString();
        if(e.length()==0)
        {
            profession.setHint("Enter your profession");
        }
        f = age.getText().toString();
         ageno=Integer.valueOf(f);
System.out.println("Age :::"+ageno);

        if(ageno<=0&&ageno>125)
        {
            age.setText("");
            age.setHint("Invalid age");
            f="";
        }
        if(f.length()!=0)
        {
            age.setHint("Invalid age");
        }

        g = contact.getText().toString();
        if(g.toCharArray().length!=10)
        {
            contact.setText("");
            g="";
            contact.setHint("Invalid mobile number");
        }
        if(g.length()==0)
        {
            contact.setHint("Enter your contact number");
        }

        System.out.println("Value of a:::" + a);
        if((confirmpass.getText().length()!=0)&&(a.length()!=0)&&(b.length()!=0)&&(c.length()!=0)&&(d.length()!=0)&&(e.length()!=0)&&(f.length()!=0)&&(g.length()!=0)&&!flag){

            System.out.print("Flag:"+flag);
            BackgroundTask backgroundTask = new BackgroundTask();
            backgroundTask.execute(a, b, c, d, e, f, g);
            flag=true;
            System.out.print("Flag:"+flag);
            finish();

            //startActivity(new Intent(this, MainActivity.class));
        }
        else
            Toast.makeText(this,"Fill all the fields!!!",Toast.LENGTH_LONG).show();
//
//            startActivity(new Intent(this,Register.class));
//        }

    }


    private class BackgroundTask extends AsyncTask<String, Void, String> {

        String add_info_url;

        @Override
        protected void onPreExecute() {
            add_info_url = "https://smart-sakhi.000webhostapp.com/loginpage.php?";
        }

        @Override
        protected String doInBackground(String... args) {
            String a, b, c, d, e, f, g;
            a = args[0];
            b = args[1];
            c = args[2];
            d = args[3];
            e = args[4];
            f = args[5];
            g = args[6];
            System.out.println("Value of a = " + a);
                try {
                    String da = URLEncoder.encode("a", "UTF-8") + "=" + URLEncoder.encode(a, "UTF-8") + "&" +
                            URLEncoder.encode("b", "UTF-8") + "=" + URLEncoder.encode(b, "UTF-8") + "&" +
                            URLEncoder.encode("c", "UTF-8") + "=" + URLEncoder.encode(c, "UTF-8") + "&" +
                            URLEncoder.encode("d", "UTF-8") + "=" + URLEncoder.encode(d, "UTF-8") + "&" +
                            URLEncoder.encode("e", "UTF-8") + "=" + URLEncoder.encode(e, "UTF-8") + "&" +
                            URLEncoder.encode("f", "UTF-8") + "=" + URLEncoder.encode(f, "UTF-8") + "&" +
                            URLEncoder.encode("g", "UTF-8") + "=" + URLEncoder.encode(g, "UTF-8");

                    URL url = new URL(add_info_url + da);
                    System.out.print("url ::" + url);
                    // Toast.makeText(getApplicationContext(), "hiiiii", Toast.LENGTH_LONG).show();
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpsURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    System.out.println(da);
                    System.out.println("url = " + url.toString());
                    bufferedWriter.write(da);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    inputStream.close();
                    httpsURLConnection.disconnect();
                    return "Registration successful!";

                } catch (Exception e2) {

                }


            return "Registration unsuccessful!";


        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String re) {
            Toast.makeText(getApplicationContext(), re, Toast.LENGTH_LONG).show();
        }
    }
}
