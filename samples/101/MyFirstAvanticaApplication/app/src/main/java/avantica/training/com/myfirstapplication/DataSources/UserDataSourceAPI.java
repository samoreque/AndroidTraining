package avantica.training.com.myfirstapplication.DataSources;

import java.util.List;

import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public class UserDataSourceAPI implements UserDataSource {

    @Override
    public User getUser() {
        return new User("samoAPI", "1234");
    }

    @Override
    public List<ClassesUser> generateClassesUser(User user) {
        return null;
    }
}
