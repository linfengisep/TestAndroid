package com.isep.linfeng.hubapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.isep.linfeng.database.entity.CallDetails;
import com.isep.linfeng.database.entity.Comment;
import com.isep.linfeng.database.entity.History;
import com.isep.linfeng.database.entity.Hub;
import com.isep.linfeng.database.entity.ScenarioTrip;
import com.isep.linfeng.database.entity.Transfer;
import com.isep.linfeng.hubapp.adapters.HubRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HubActivity extends AppCompatActivity implements HubRecyclerViewAdapter.HubItemClickListener{
    private RecyclerView hubRecyclerView;
    private RecyclerView.Adapter hubAdapter;
    private RecyclerView.LayoutManager hubLayoutManager;
    private List<Hub> hubList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        Toolbar toolbar = findViewById(R.id.hub_toolbar);
        setSupportActionBar(toolbar);

        loadingFakeData();
        hubRecyclerView = findViewById(R.id.hub_recycler_view);
        hubRecyclerView.setHasFixedSize(true);
        hubLayoutManager = new LinearLayoutManager(this);
        hubRecyclerView.setLayoutManager(hubLayoutManager);
        hubAdapter = new HubRecyclerViewAdapter(hubList,getApplicationContext(),HubActivity.this);
        hubRecyclerView.setAdapter(hubAdapter);
    }

    private void loadingFakeData(){
        List<ScenarioTrip> listScenarioTrip = new ArrayList<>();
        listScenarioTrip.add(new ScenarioTrip());
        List<Transfer> listTransfer = new ArrayList<>();
        listTransfer.add(new Transfer("LA","3 ms","Hier"));
        List<History> listHistory = new ArrayList<>();
        listHistory.add(new History("3 second","incoming","3 heures"));
        List<Comment> listComment = new ArrayList<>();
        listComment.add(new Comment("journey is good"));
        CallDetails callDetails = new CallDetails("Barbara","+7 12 34 56 78",listTransfer, listScenarioTrip,listHistory,listComment);

        Hub hub = new Hub("Incoming","Louise","+7 12 34 56 78",
                "John answerd","16:32",false,callDetails);
        hubList.add(hub);
        List<ScenarioTrip> listScenarioTrip1 = new ArrayList<>();
        listScenarioTrip.add(new ScenarioTrip());
        List<Transfer> listTransfer1 = new ArrayList<>();
        listTransfer.add(new Transfer("LA","3 ms","Hier"));
        List<History> listHistory1 = new ArrayList<>();
        listHistory.add(new History("3 second","incoming","3 heures"));
        List<Comment> listComment1 = new ArrayList<>();
        listComment.add(new Comment("journey is good"));
        CallDetails callDetails1 = new CallDetails("Barbara","+7 12 34 56 78",listTransfer1, listScenarioTrip1,listHistory1,listComment1);

        Hub hub1 = new Hub("Outgoing","Lee","+7 12 34 56 78",
                "Ok j'arrive","10:39",true,callDetails1);
        hubList.add(hub1);

        List<ScenarioTrip> listScenarioTrip2 = new ArrayList<>();
        listScenarioTrip.add(new ScenarioTrip());
        List<Transfer> listTransfer2 = new ArrayList<>();
        listTransfer.add(new Transfer("LA","3 ms","Hier"));
        List<History> listHistory2 = new ArrayList<>();
        listHistory.add(new History("3 second","incoming","3 heures"));
        List<Comment> listComment2 = new ArrayList<>();
        listComment.add(new Comment("journey is good"));
        CallDetails callDetails2 = new CallDetails("Barbara","+7 12 34 56 78",listTransfer2, listScenarioTrip2,listHistory2,listComment2);

        Hub hub2 = new Hub("SMS","John","+7 12 34 56 78",
                "support is comming","15:02",false,callDetails2);
        hubList.add(hub2);

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
}
