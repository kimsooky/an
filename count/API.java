package com.ssaurel.count;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class API extends AppCompatActivity implements PostAdapter.CallbackPost {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Item> mList;

    @Override
    public void  saveFav(Item item) {
        // เขียน ให้ เอา ค่า ไอเท็ม ไปเซฟลง ดาต้าเบส
        //
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
        mList = new ArrayList<>();
        fetchData();


    }

    private void fetchData() {

        String url = "https://www.json-generator.com/api/json/get/coenWeeYHS?indent=2";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("hits");

                    for (int i = 0 ; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String imageUrl = jsonObject.getString("user");
                        int likes = jsonObject.getInt("likes");
                        String tags = jsonObject.getString("webformatURL");


                        Item post = new Item(tags, imageUrl, likes);
                        mList.add(post);



                    }

                    PostAdapter adapter = new PostAdapter(API.this, mList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(API.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(API.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }




}