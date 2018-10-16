package avantica.training.com.myfirstapplication;

import android.app.Application;

public class MyFirstApplication extends Application {
    private Person user = new Person("samuel", R.drawable.ic_launcher_background);
    private static MyFirstApplication instance;

    public static MyFirstApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }
}
