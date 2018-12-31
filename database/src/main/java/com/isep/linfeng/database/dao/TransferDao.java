package com.isep.linfeng.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.isep.linfeng.database.entity.Transfer;

import java.util.List;

@Dao
public interface TransferDao {
    @Query("SELECT * FROM transfer ")
    List<Transfer> getAll();
}
