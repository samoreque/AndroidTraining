package avantica.training.com.myfirstapplication.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import avantica.training.com.myfirstapplication.Person;

public class User implements IModel {

    public static final String TABLE_NAME = "user";
    public static final String FIELD_LOGIN = "login";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_PASSWORD = "password";

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    FIELD_ID + " INTEGER AUTOINCREMENT PRIMARY KEY ," +
                    FIELD_LOGIN + " TEXT," +
                    FIELD_PASSWORD + " TEXT)";

    private Person person;
    private long id;
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void create(SQLiteDatabase db) {
        id = db.insert(TABLE_NAME, null, toContentValues());
        db.close();
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(FIELD_LOGIN, login);
        cv.put(FIELD_PASSWORD, password);
        return cv;
    }
}
