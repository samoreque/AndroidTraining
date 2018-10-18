package avantica.training.com.myfirstapplication.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public interface IModel {
    void create(SQLiteDatabase db);
    ContentValues toContentValues();
}
