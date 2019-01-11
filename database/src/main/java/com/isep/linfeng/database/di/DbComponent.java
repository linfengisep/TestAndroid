package com.isep.linfeng.database.di;

import com.isep.linfeng.database.dao.CallDetailsDao;
import com.isep.linfeng.database.dao.CommentDao;
import com.isep.linfeng.database.dao.HistoryDao;
import com.isep.linfeng.database.dao.HubDao;
import com.isep.linfeng.database.dao.ScenarioTripDao;
import com.isep.linfeng.database.dao.TransferDao;
import dagger.Subcomponent;

@Subcomponent(modules = DbModule.class)
public interface DbComponent {
    HubDao hubDao();
    HistoryDao historyDao();
    TransferDao transferDao();
    ScenarioTripDao scenarioTripDao();
    CommentDao commentDao();
    CallDetailsDao callDetailsDao();
}
