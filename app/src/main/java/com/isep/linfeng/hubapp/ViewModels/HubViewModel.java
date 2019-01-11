package com.isep.linfeng.hubapp.ViewModels;
import android.arch.lifecycle.ViewModel;
import com.isep.linfeng.database.di.DbComponent;
import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HubViewModel extends ViewModel {
    private DbComponent dbComponent;
    @Inject
    public HubViewModel(DbComponent dbComponent){
        this.dbComponent = dbComponent;
    }
/*
    private void loadHubs(){
        compositeDisposable.add(
            dbComponent.hubDao()
                 .getAll()
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(hubs-> {

                        })
            );
    }

*/
}
