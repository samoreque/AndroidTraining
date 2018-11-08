package avantica.training.com.myfirstapplication.DataSources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import avantica.training.com.myfirstapplication.MyFirstApplication;
import avantica.training.com.myfirstapplication.databases.FirstAppDataBaseHelper;
import avantica.training.com.myfirstapplication.databases.UserDatabaseManager;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public class UserDataSourceDB implements UserDataSource {
    @Override
    public User getUser() {
        return new User("samoDB", "1234");
    }

    @Override
    public List<ClassesUser> generateClassesUser(User user) {
        try {
            FirstAppDataBaseHelper dataBaseHelper = new FirstAppDataBaseHelper(MyFirstApplication.getInstance());
            List<ClassesUser> userClassesList = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                ClassesUser cls = new ClassesUser("Inf-10" + i, new Date(), random.nextInt(100));
                userClassesList.add(cls);
            }
            UserDatabaseManager.saveUserInfo(user, userClassesList);
            return userClassesList;
            //getUserView().onGeneratedClassesSuccess(user, userClassesList);
        } catch (Exception e) {
            //getUserView().onError(e);
        }
        return null;
    }
}
