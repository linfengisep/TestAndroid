package com.isep.linfeng.hubapp;

import android.app.Application;

import com.isep.linfeng.database.di.DbComponent;
import com.isep.linfeng.hubapp.di.AppComponent;
import com.isep.linfeng.hubapp.di.DaggerAppComponent;

public class HubApp extends Application {
    private DbComponent dbComponent;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .context(this)
                .databaseName(BuildConfig.DATABASE_NAME)
                .build();

        dbComponent = appComponent.dbComponent();
    }
}
