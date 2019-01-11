package com.isep.linfeng.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.isep.linfeng.database.entity.Hub;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface HubDao {
    @Query("SELECT * FROM hub")
    Flowable<List<Hub>> getAll();
    @Query("SELECT * FROM hub WHERE id = (:hubId) ")
    Hub getHubById(int hubId);

    @Insert
    void insertAll(Hub... hub);
    @Delete
    void delete(Hub hub);
}
