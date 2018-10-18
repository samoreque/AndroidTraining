package avantica.training.com.myfirstapplication;

import android.app.Application;
import android.content.SharedPreferences;

public class MyFirstApplication extends Application {
    private Person user = new Person("samuel", R.drawable.ic_launcher_background);
    private static MyFirstApplication instance;

    SharedPreferences preferences;

    public static MyFirstApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preferences = this.getSharedPreferences(MyFirstApplication.class.getName(), MODE_PRIVATE);
        preferences.getString("color", "RED");
    }

    public Person getUser() {
        return new Person(
            preferences.getString(Person.USER_NAME, user.Name),
            preferences.getInt(Person.USER_PHOTO, user.photoResId));
    }

    public void setUser(Person user) {
        saveUser(user);
        this.user = user;
    }

    private void saveUser(Person user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Person.USER_NAME, user.Name);
        editor.putInt(Person.USER_PHOTO, user.photoResId);
        editor.apply();
    }
}
