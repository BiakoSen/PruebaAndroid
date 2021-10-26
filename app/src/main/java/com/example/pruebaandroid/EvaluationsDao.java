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

    @Query("SELECT COUNT(commerce) FROM evaluations WHERE commerce LIKE 'Pricesmart' GROUP BY commerce")
    int getAll_pricesmart();

    @Query("SELECT COUNT(commerce) FROM evaluations WHERE commerce LIKE 'Colonia' GROUP BY commerce")
    int getAll_colonia();

    @Insert
    void insert(Evaluations evaluations);

    @Delete
    void delete(Evaluations evaluations);

    @Update
    void update(Evaluations evaluations);

}
