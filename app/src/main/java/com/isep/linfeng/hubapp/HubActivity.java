package com.isep.linfeng.hubapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isep.linfeng.database.entity.CallDetails;
import com.isep.linfeng.database.entity.Comment;
import com.isep.linfeng.database.entity.History;
import com.isep.linfeng.database.entity.Hub;
import com.isep.linfeng.database.entity.ScenarioTrip;
import com.isep.linfeng.database.entity.Transfer;
import com.isep.linfeng.hubapp.adapters.HubRecyclerViewAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HubActivity extends AppCompatActivity implements HubRecyclerViewAdapter.HubItemClickListener{
    private RecyclerView hubRecyclerView;
    private RecyclerView.Adapter hubAdapter;
    private RecyclerView.LayoutManager hubLayoutManager;
    private List<Hub> hubList = new ArrayList<>();
    private AppCompatImageView searchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        Toolbar toolbar = findViewById(R.id.hub_toolbar);
        setSupportActionBar(toolbar);
        searchImageView = findViewById(R.id.search_icon);

        loadingFakeData();
        hubRecyclerView = findViewById(R.id.hub_recycler_view);
        hubRecyclerView.setHasFixedSize(true);
        hubLayoutManager = new LinearLayoutManager(this);
        hubRecyclerView.setLayoutManager(hubLayoutManager);
        hubAdapter = new HubRecyclerViewAdapter(hubList,getApplicationContext(),HubActivity.this);
        hubRecyclerView.setAdapter(hubAdapter);

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent filterIntent = new Intent(getApplicationContext(),FilterActivity.class);
                startActivity(filterIntent);
            }
        });
    }

    private void loadingFakeData(){
        String data = loadJsonFromAsset();
        Type listType = new TypeToken<ArrayList<Hub>>(){}.getType();
        hubList = new Gson().fromJson(data,listType);
    }

    @Override
    public void onHubItemClick(int hubIndex) {
        Toast.makeText(this,"good"+hubIndex,Toast.LENGTH_SHORT).show();
        Intent callDetailIntent = new Intent(getApplicationContext(),CallDetailActivity.class);
        startActivity(callDetailIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.hub_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //startActivity(new Intent(this,CallDetailActivity.class));
                Toast.makeText(this,"home click",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.setting:
                Toast.makeText(this,"en cours",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private String loadJsonFromAsset(){
        String json = null;
        InputStream is = null;
        try{
            is = this.getAssets().open("hubData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer,"UTF-8");
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }finally {
            if(is !=null){
                try{
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return json;
    }
}
