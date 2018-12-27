package com.isep.linfeng.hubapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.isep.linfeng.hubapp.adapters.FilterAdapter;

import java.util.Arrays;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    private List<String> data;
    private RecyclerView recyclerViewN,recyclerViewI,recyclerViewO;
    private RecyclerView.Adapter filterAdapterN,filterAdapterI,filterAdapterO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = this.findViewById(R.id.filter_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        }

        loadingData();
        initRecyclerViews();
    }

    private void loadingData(){
        data = Arrays.asList("Professional","Ringover IVR","Personal","Professional","Personal");
    }

    private void initRecyclerViews(){
        recyclerViewN = findViewById(R.id.numbers_recycler_view);
        recyclerViewN.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerViewN.setLayoutManager(gridLayoutManager);
        filterAdapterN = new FilterAdapter(data,getApplicationContext());
        recyclerViewN.setAdapter(filterAdapterN);

        recyclerViewI = findViewById(R.id.ivr_recycler_view);
        recyclerViewI.setHasFixedSize(true);
        GridLayoutManager gridLayoutManagerI = new GridLayoutManager(this,3);
        recyclerViewI.setLayoutManager(gridLayoutManagerI);
        filterAdapterI = new FilterAdapter(data,getApplicationContext());
        recyclerViewI.setAdapter(filterAdapterI);

        recyclerViewO = findViewById(R.id.others_recycler_view);
        recyclerViewO.setHasFixedSize(true);
        GridLayoutManager gridLayoutManagerO = new GridLayoutManager(this,3);
        recyclerViewO.setLayoutManager(gridLayoutManagerO);
        filterAdapterO = new FilterAdapter(data,getApplicationContext());
        recyclerViewO.setAdapter(filterAdapterO);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.filter_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this,HubActivity.class));
                finish();
                break;
            case R.id.filter_clear:
                Toast.makeText(this,"filter en cours",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
