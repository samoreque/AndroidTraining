package avantica.training.com.myfirstapplication;

import android.app.Activity;
import android.os.AsyncTask;

import java.util.List;

import avantica.training.com.myfirstapplication.databases.UserDatabaseManager;
import avantica.training.com.myfirstapplication.models.ClassesUser;

public class GetUserClassesAsyncTask extends AsyncTask<Integer, Void, List<ClassesUser>> {

    private IGetClassesUserListener listener;

    public GetUserClassesAsyncTask(IGetClassesUserListener listener) {
        this.listener = listener;
    }
    @Override
    protected List<ClassesUser> doInBackground(Integer... integers) {
        return UserDatabaseManager.getClassesUser(integers[0]);
    }

    @Override
    protected void onPostExecute(List<ClassesUser> classesUsers) {
        super.onPostExecute(classesUsers);
        listener.onGetClassesUser(classesUsers);
    }

    public interface IGetClassesUserListener{
        void onGetClassesUser(List<ClassesUser> users);
    }
}
