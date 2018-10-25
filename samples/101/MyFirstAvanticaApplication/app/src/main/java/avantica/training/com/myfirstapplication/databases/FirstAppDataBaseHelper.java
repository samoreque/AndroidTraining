package avantica.training.com.myfirstapplication.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public class FirstAppDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATA_BASE_NAME = "FirstAppDataBaseHelper.db";
    public static final int DATA_BASE_VERSION = 4;

    public FirstAppDataBaseHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(User.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("FirstAppDataBaseHelper","onUpgrade");
        switch (oldVersion) {
            case 1:
                // updates or inserts
            case 2:
                // updates or inserts
            case 3:
                sqLiteDatabase.execSQL(ClassesUser.SQL_CREATE_TABLE);
        }
    }
}
