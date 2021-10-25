package com.example.pruebaandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EvaluationsDao {

    @Query("SELECT * FROM evaluations")
    List<Evaluations> getAll();

    @Insert
    void insert(Evaluations evaluations);

    @Delete
    void delete(Evaluations evaluations);

    @Update
    void update(Evaluations evaluations);

}
