package avantica.training.com.myfirstapplication.Presenters;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import avantica.training.com.myfirstapplication.databases.FirstAppDataBaseHelper;
import avantica.training.com.myfirstapplication.databases.UserDatabaseManager;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;
import avantica.training.com.myfirstapplication.views.UserView;

public class UserPresenter extends Presenter<UserView> {

    public UserPresenter(UserView view) {
        super(view);
    }

    @Override
    public void initPresenter() {
        // User can be gettting of any resource
        User user = new User("samo", "1234");
        getUserView().onUser(this, user);

    }
    public void generateUserClasses(Context context, User user) {
        try {
            FirstAppDataBaseHelper dataBaseHelper = new FirstAppDataBaseHelper(context);
            List<ClassesUser> userClassesList = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                ClassesUser cls = new ClassesUser("Inf-10" + i, new Date(), random.nextInt(100));
                userClassesList.add(cls);
            }
            UserDatabaseManager.saveUserInfo(user, userClassesList);
            getUserView().onGeneratedClassesSuccess(user, userClassesList);
        } catch (Exception e) {
            getUserView().onError(e);
        }
    }

    private UserView getUserView() {
        return getView();
    }
}
