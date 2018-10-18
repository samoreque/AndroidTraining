package avantica.training.com.myfirstapplication;

import android.content.Context;

public class Person {
    public static final String USER_NAME="username";

    public static final String USER_PHOTO="photo";
    public String Name;
    public int photoResId;

    Person(String name, int photoResId) {
        Name = name;
        this.photoResId = photoResId;
    }
}
