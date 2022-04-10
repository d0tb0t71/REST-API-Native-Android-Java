package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView postRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postRecyclerView = findViewById(R.id.postRecyclerView);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getPost().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {

                if(response.body().size()>0){

                    List<PostPojo> list = response.body();
                    PostAdapter postAdapter = new PostAdapter(list,MainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    postRecyclerView.setLayoutManager(linearLayoutManager);
                    postRecyclerView.setAdapter(postAdapter);

                    Toast.makeText(MainActivity.this, "List Is Not Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Lis Is Empty", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                
            }
        });

    }
}