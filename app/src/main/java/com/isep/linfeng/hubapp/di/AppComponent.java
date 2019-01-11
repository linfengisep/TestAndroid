package com.isep.linfeng.hubapp.di;

import android.support.annotation.Nullable;

import com.isep.linfeng.database.di.DbComponent;
import com.isep.linfeng.database.roomDB.HubDatabase;
import com.isep.linfeng.hubapp.HubApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    DbComponent dbComponent();
    HubDatabase hubDatabase();

    @Component.Builder
    interface Builder{
      @BindsInstance  Builder context(HubApp app);
      @BindsInstance Builder databaseName(String dbName);

      AppComponent build();
    }
}
