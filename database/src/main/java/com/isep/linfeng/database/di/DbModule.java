package com.isep.linfeng.database.di;

import com.isep.linfeng.database.dao.CallDetailsDao;
import com.isep.linfeng.database.dao.CommentDao;
import com.isep.linfeng.database.dao.HistoryDao;
import com.isep.linfeng.database.dao.HubDao;
import com.isep.linfeng.database.dao.ScenarioTripDao;
import com.isep.linfeng.database.dao.TransferDao;
import com.isep.linfeng.database.roomDB.HubDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DbModule {
    @Provides
    public static HubDao hubDao(HubDatabase hubDatabase){
        return hubDatabase.hubDao();
    }

    @Provides
    public static HistoryDao historyDao(HubDatabase hubDatabase){
        return hubDatabase.historyDao();
    }

    @Provides
    public static TransferDao transferDao(HubDatabase hubDatabase){
        return hubDatabase.transferDao();
    }

    @Provides
    public static ScenarioTripDao scenarioTripDao(HubDatabase hubDatabase){
        return hubDatabase.scenarioTripDao();
    }

    @Provides
    public static CommentDao commentDao(HubDatabase hubDatabase){
        return hubDatabase.commentDao();
    }

    @Provides
    public static CallDetailsDao callDetailsDao(HubDatabase hubDatabase){
        return hubDatabase.callDetailsDao();
    }
}
