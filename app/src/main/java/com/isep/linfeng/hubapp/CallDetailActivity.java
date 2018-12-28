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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.isep.linfeng.custom_views.UserCardView;
import com.isep.linfeng.database.entity.Transfer;
import com.isep.linfeng.hubapp.Utils.DpUtil;
import com.isep.linfeng.hubapp.adapters.InfoTableAdapter;

import java.util.ArrayList;
import java.util.List;

public class CallDetailActivity extends AppCompatActivity{
    private static final String CALLER_NAME = "CALLER_NAME";
    private static final String CALLER_NUMBER = "CALLER_NUMBER";
    private static final String CALLER_PHOTO_URL = "CALLER_PHOTO_URL";

    private UserCardView userCardView;

    private List<Transfer> transferList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);
        userCardView = findViewById(R.id.caller_card_view);
        getExtraData();
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

    private void getExtraData(){
        Intent data = getIntent();
        userCardView.setTitle(data.getStringExtra(CALLER_NAME));
        userCardView.setSubtitle(data.getStringExtra(CALLER_NUMBER));
        userCardView.setIconUrl(data.getStringExtra(CALLER_PHOTO_URL));
    }

    private void initRecyclerViews(){
        RecyclerView transferRecyclerView,scenarioRecyclerView,historyRecyclerView;
        RecyclerView.LayoutManager layoutManagerT,layoutManagerS,layoutManagerH;
        RecyclerView.Adapter infoTableAdapterT,infoTableAdapterS,infoTableAdapterH;

        transferRecyclerView = findViewById(R.id.transfer_recycler_view);
        transferRecyclerView.setHasFixedSize(true);
        layoutManagerT = new LinearLayoutManager(this);
        transferRecyclerView.setLayoutManager(layoutManagerT);
        infoTableAdapterT = new InfoTableAdapter(this,transferList,true,0);
        transferRecyclerView.setAdapter(infoTableAdapterT);

        scenarioRecyclerView = findViewById(R.id.scenario_recycler_view);
        scenarioRecyclerView.setHasFixedSize(true);
        layoutManagerS = new LinearLayoutManager(this);
        scenarioRecyclerView.setLayoutManager(layoutManagerS);
        infoTableAdapterS = new InfoTableAdapter(this,transferList,true,20);
        scenarioRecyclerView.setAdapter(infoTableAdapterS);
        View scenarioLinker = findViewById(R.id.scenario_linker);
        ViewGroup.MarginLayoutParams params =(ViewGroup.MarginLayoutParams)scenarioLinker.getLayoutParams();
        params.leftMargin = DpUtil.dpToPixel(10,this);

        historyRecyclerView = findViewById(R.id.history_recycler_view);
        historyRecyclerView.setHasFixedSize(true);
        layoutManagerH = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(layoutManagerH);
        infoTableAdapterH = new InfoTableAdapter(this,transferList,false,0);
        historyRecyclerView.setAdapter(infoTableAdapterH);
    }

    private void loadingFakeData(){
        Transfer transfer = new Transfer("Monica","15 min","Hier");
        Transfer transfer1 = new Transfer("Rachel","30 sec","25/12/2018");
        Transfer transfer2 = new Transfer("Chandeler","30 sec","11/12/2018");
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
                Intent hubIntent  = new Intent(this,HubActivity.class);
                hubIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(hubIntent);
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
