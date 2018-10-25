package avantica.training.com.myfirstapplication.databases;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import avantica.training.com.myfirstapplication.MyFirstApplication;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public class UserDatabaseManager {

    public static final Object lock = new Object();

    public synchronized static void saveUserInfo(User user, List<ClassesUser> classes){
        FirstAppDataBaseHelper dataBaseHelper = new FirstAppDataBaseHelper(MyFirstApplication.getInstance());
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        db.beginTransaction();

        try {
            user.create(db);
            long userId = user.getId();
            for(ClassesUser cls : classes) {
                cls.setUserId(userId);
                cls.create(db);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(UserDatabaseManager.class.getSimpleName(), "Error saving user ", e);
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public static List<ClassesUser> getClassesUser(Integer userId) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
