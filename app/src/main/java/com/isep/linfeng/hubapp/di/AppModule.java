package com.isep.linfeng.hubapp.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.isep.linfeng.database.roomDB.HubDatabase;
import com.isep.linfeng.hubapp.HubApp;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Binds
    public abstract Context context(HubApp context);

    @Singleton
    @Provides
    public static HubDatabase getDatabase(Context context, String dbName){
        return Room.databaseBuilder(context,HubDatabase.class,dbName)
                .build();
    }

}
