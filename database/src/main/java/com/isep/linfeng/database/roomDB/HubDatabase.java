package com.isep.linfeng.database.roomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.isep.linfeng.database.dao.CallDetailsDao;
import com.isep.linfeng.database.dao.CommentDao;
import com.isep.linfeng.database.dao.HistoryDao;
import com.isep.linfeng.database.dao.HubDao;
import com.isep.linfeng.database.dao.ScenarioTripDao;
import com.isep.linfeng.database.dao.TransferDao;
import com.isep.linfeng.database.entity.CallDetails;
import com.isep.linfeng.database.entity.Comment;
import com.isep.linfeng.database.entity.History;
import com.isep.linfeng.database.entity.Hub;
import com.isep.linfeng.database.entity.ScenarioTrip;
import com.isep.linfeng.database.entity.Transfer;

import dagger.Provides;

@Database(entities = {
        Hub.class, CallDetails.class, Comment.class, History.class,
        ScenarioTrip.class, Transfer.class
},version = 1)
public abstract class HubDatabase extends RoomDatabase{
    public abstract HubDao hubDao();
    public abstract CallDetailsDao callDetailsDao();
    public abstract CommentDao commentDao();
    public abstract HistoryDao historyDao();
    public abstract ScenarioTripDao scenarioTripDao();
    public abstract TransferDao transferDao();
}
