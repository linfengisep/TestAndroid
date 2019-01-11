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
import com.isep.linfeng.database.entity.Hub;
import com.isep.linfeng.hubapp.ViewModels.HubViewModel;
import com.isep.linfeng.hubapp.adapters.HubRecyclerViewAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HubActivity extends AppCompatActivity implements HubRecyclerViewAdapter.HubItemClickListener{
    private static final String CALLER_NAME = "CALLER_NAME";
    private static final String CALLER_NUMBER = "CALLER_NUMBER";
    private static final String CALLER_PHOTO_URL = "CALLER_PHOTO_URL";

    private List<Hub> hubList = new ArrayList<>();
    @Inject
    private HubViewModel hubViewModel;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        Toolbar toolbar = findViewById(R.id.hub_toolbar);
        setSupportActionBar(toolbar);
        AppCompatImageView searchImageView= findViewById(R.id.search_icon);

        insertDataToDBRoom();

        RecyclerView hubRecyclerView = findViewById(R.id.hub_recycler_view);
        hubRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager hubLayoutManager = new LinearLayoutManager(this);
        hubRecyclerView.setLayoutManager(hubLayoutManager);
        RecyclerView.Adapter hubAdapter = new HubRecyclerViewAdapter(hubList,getApplicationContext(),HubActivity.this);
        hubRecyclerView.setAdapter(hubAdapter);

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent filterIntent = new Intent(getApplicationContext(),FilterActivity.class);
                startActivity(filterIntent);
            }
        });
    }

    private void insertDataToDBRoom(){
        String data = loadJsonFromAsset();
        Type listType = new TypeToken<ArrayList<Hub>>(){}.getType();
        compositeDisposable.add(

        );
        hubList = new Gson().fromJson(data,listType);
    }

    @Override
    public void onHubItemClick(int hubIndex) {
        //Toast.makeText(this,"item index:"+hubIndex,Toast.LENGTH_SHORT).show();
        Intent callDetailIntent = new Intent(getApplicationContext(),CallDetailActivity.class);
        callDetailIntent.putExtra(CALLER_NAME,hubList.get(hubIndex).getTitle());
        callDetailIntent.putExtra(CALLER_NUMBER,hubList.get(hubIndex).getSubTitle());
        callDetailIntent.putExtra(CALLER_PHOTO_URL,hubList.get(hubIndex).getPhotoUrl());
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
                startActivity(new Intent(this,CallDetailActivity.class));
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
        String json;
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

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}
