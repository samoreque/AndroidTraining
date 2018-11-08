package avantica.training.com.myfirstapplication.DataSources;

import java.util.List;

import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public interface UserDataSource extends DataSource {
    User getUser();
    List<ClassesUser> generateClassesUser(User user);
}
