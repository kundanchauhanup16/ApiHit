package com.example.apigetkshitij;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String url = "https://www.7timer.info/";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myapi api = retrofit.create(myapi.class);
        Call<ResponseBody> call = api.getmodels();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String responsee = response.body().string();
                        JSONObject jsonObject = new JSONObject(responsee);
                        if (jsonObject.getString("product").equalsIgnoreCase("astro")) {
                            JSONArray jsonArray = jsonObject.getJSONArray("dataseries");
                            List<Model> list = new ArrayList<>();
                            if (jsonArray.length() > 0) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    JSONObject jsonObject2 = jsonObject1.getJSONObject("wind10m");
                                    list.add(new Model(
                                            jsonObject1.getInt("timepoint"),
                                            jsonObject1.getInt("cloudcover"),
                                            jsonObject1.getInt("seeing"),
                                            jsonObject1.getInt("transparency"),
                                            jsonObject1.getInt("lifted_index"),
                                            jsonObject1.getInt("rh2m"),
                                            jsonObject1.getInt("temp2m"),
                                            jsonObject1.getString("prec_type"),
                                            new Model.Wind10m(jsonObject2.getString("direction"), jsonObject2.getInt("speed"))

                                    ));

                                }

                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                MyAdapter adapter = new MyAdapter(MainActivity.this, list);
                                recyclerView.setAdapter(adapter);


                            } else {
                                Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "" + jsonObject.getString("status"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }

//
//                second way
//                if (response.isSuccessful()){
//                    List<Model> dataaa = new ArrayList<>();
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                    MyAdapter myAdapter=new MyAdapter(MainActivity.this, dataaa);
//                    recyclerView.setAdapter(myAdapter);
//                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Fail Error", "data not found");

            }
        });
    }
}