package avantica.training.com.myfirstapplication.Presenters;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import avantica.training.com.myfirstapplication.DataSources.UserDataSourceAPI;
import avantica.training.com.myfirstapplication.DataSources.UserDataSourceDB;
import avantica.training.com.myfirstapplication.Respositories.UserRepository;
import avantica.training.com.myfirstapplication.databases.FirstAppDataBaseHelper;
import avantica.training.com.myfirstapplication.databases.UserDatabaseManager;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;
import avantica.training.com.myfirstapplication.views.UserView;

public class UserPresenter extends Presenter<UserView> {
    private UserRepository repository;

    public UserPresenter(UserView view) {
        super(view);
        Random random = new Random();
        if(random.nextBoolean()) {
            repository = new UserRepository(new UserDataSourceDB());
        } else {
            repository = new UserRepository(new UserDataSourceAPI());
        }
    }

    @Override
    public void initPresenter() {
        // User can be gettting of any resource

        getUserView().onUser(this, repository.getUser());

    }
    public void generateUserClasses(Context context, User user) {

        try {
            getUserView().onGeneratedClassesSuccess(user, repository.generateClassesUser(user));
        } catch (Exception e) {
            getUserView().onError(e);
        }
    }

    private UserView getUserView() {
        return getView();
    }
}
