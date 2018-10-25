package avantica.training.com.myfirstapplication.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

import avantica.training.com.myfirstapplication.databases.UserDatabaseManager;

import static avantica.training.com.myfirstapplication.models.User.FIELD_LOGIN;

public class ClassesUser implements IModel {

    public static final String TABLE_NAME = "classes_user";
    public static final String FIELD_USER_ID = "id_user";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_CLASS = "class";

    public static final String FIELD_DATE_TIME = "datetime";
    public static final String FIELD_SCORE = "score";

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_USER_ID + " INTEGER NOT NULL," +
                    FIELD_CLASS + " TEXT NOT NULL," +
                    FIELD_DATE_TIME + " INTEGER," +
                    FIELD_SCORE + " INTEGER DEFAULT 0," +
                    " FOREIGN KEY (" + FIELD_USER_ID + ") REFERENCES " + User.TABLE_NAME + "(" + User.FIELD_ID + "));";

    private long userId;
    private long _id;
    private String classes;
    private Date datetime;
    private int score;

    public ClassesUser( String classes, Date datetime, int score) {
        this.classes = classes;
        this.datetime = datetime;
        this.score = score;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public void create(SQLiteDatabase db) {
        _id = db.insert(TABLE_NAME, null, toContentValues());
        //db.close();
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(FIELD_USER_ID, userId);
        cv.put(FIELD_CLASS, classes);
        cv.put(FIELD_DATE_TIME, datetime.getTime());
        cv.put(FIELD_SCORE, score);
        return cv;
    }
}
