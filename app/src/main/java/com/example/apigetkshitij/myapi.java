package com.example.apigetkshitij;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface myapi {
    @GET("bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0")
    //Here we can pass Response body and json object
    Call<ResponseBody> getmodels();
}
