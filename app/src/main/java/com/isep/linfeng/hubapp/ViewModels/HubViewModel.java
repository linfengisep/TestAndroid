package com.isep.linfeng.hubapp.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.isep.linfeng.database.roomDB.HubDatabase;
import com.isep.linfeng.database.entity.Hub;

import java.util.List;

import javax.inject.Inject;

public class HubViewModel extends ViewModel {
    @Inject
    private HubDatabase hubDatabase;
    private MutableLiveData<List<Hub>> hubs;
    public LiveData<List<Hub>> getAll(){
        if(hubs !=null){
            hubs = new MutableLiveData<>();
            loadHubs();
        }
        return hubs;
    }

    private void loadHubs(){
        hubDatabase.hubDao().getAll();
    }
}
