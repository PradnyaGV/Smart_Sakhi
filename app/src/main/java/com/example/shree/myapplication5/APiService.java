package com.example.shree.myapplication5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by comp on 11-03-2018.
 */

public interface APiService {
    @GET("schemes_by_age.php")
    Call<List<Fetch_scheme>> getTransationDetailsFilter(@Query("agegroup") int agegroup);


    @GET("get_schemes.php")
    Call<List<Fetch_scheme>> getTransationDetails(@Query("cid") int id);

    @GET("get_scheme_details.php")
    Call<List<Fetch_Scheme_Details>> getSchemeDetails(@Query("cid") int cid,@Query("sid") int sid);
}
