package avantica.training.com.myfirstapplication.Respositories;

import java.util.List;

import avantica.training.com.myfirstapplication.DataSources.UserDataSource;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public class UserRepository extends Repository<UserDataSource> implements UserDataSource {

    public UserRepository(UserDataSource dataSource) {
        super(dataSource);
    }

    @Override
    public User getUser() {
        return getDataSource().getUser();
    }

    @Override
    public List<ClassesUser> generateClassesUser(User user) {
        return getDataSource().generateClassesUser(user);
    }

    @Override
    public UserDataSource getDataSource() {
        return super.getDataSource();
    }
}
