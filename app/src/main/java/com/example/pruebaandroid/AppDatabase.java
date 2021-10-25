package com.example.pruebaandroid;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Evaluations.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EvaluationsDao evaluationsDao();
}
