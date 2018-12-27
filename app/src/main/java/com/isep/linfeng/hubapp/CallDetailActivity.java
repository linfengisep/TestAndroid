package com.isep.linfeng.hubapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.isep.linfeng.database.entity.Transfer;
import com.isep.linfeng.hubapp.adapters.InfoTableAdapter;

import java.util.ArrayList;
import java.util.List;

public class CallDetailActivity extends AppCompatActivity{
    private RecyclerView transferRecyclerView,scenarioRecyclerView,historyRecyclerView;
    private RecyclerView.LayoutManager layoutManagerT,layoutManagerS,layoutManagerH;
    private RecyclerView.Adapter infoTableAdapterT,infoTableAdapterS,infoTableAdapterH;
    private List<Transfer> transferList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);
        Fresco.initialize(this);
        loadingFakeData();
        initRecyclerViews();
        Toolbar toolbar = this.findViewById(R.id.call_detail_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        }
    }

    private void initRecyclerViews(){
        transferRecyclerView = findViewById(R.id.transfer_recycler_view);
        transferRecyclerView.setHasFixedSize(true);
        layoutManagerT = new LinearLayoutManager(this);
        transferRecyclerView.setLayoutManager(layoutManagerT);
        infoTableAdapterT = new InfoTableAdapter(this,transferList,true);
        transferRecyclerView.setAdapter(infoTableAdapterT);
        scenarioRecyclerView = findViewById(R.id.scenario_recycler_view);
        scenarioRecyclerView.setHasFixedSize(true);
        layoutManagerS = new LinearLayoutManager(this);
        scenarioRecyclerView.setLayoutManager(layoutManagerS);
        infoTableAdapterS = new InfoTableAdapter(this,transferList,true);
        scenarioRecyclerView.setAdapter(infoTableAdapterS);

        historyRecyclerView = findViewById(R.id.history_recycler_view);
        historyRecyclerView.setHasFixedSize(true);
        layoutManagerH = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(layoutManagerH);
        infoTableAdapterH = new InfoTableAdapter(this,transferList,false);
        historyRecyclerView.setAdapter(infoTableAdapterH);
    }

    private void loadingFakeData(){
        Transfer transfer = new Transfer("Paris","3 heures","Hier");
        Transfer transfer1 = new Transfer("Londres","2 heures","25/12/2018");
        Transfer transfer2 = new Transfer("Madrid","1.5heures","11/12/2018");
        transferList.add(transfer);
        transferList.add(transfer2);
        transferList.add(transfer1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.call_detail_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this,HubActivity.class));
                finish();
                break;
            case R.id.call_detail_setting:
                Toast.makeText(this,"en cours",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
