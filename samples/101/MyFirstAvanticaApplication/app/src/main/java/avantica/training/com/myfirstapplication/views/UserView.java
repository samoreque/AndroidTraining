package avantica.training.com.myfirstapplication.views;

import java.util.List;

import avantica.training.com.myfirstapplication.Presenters.UserPresenter;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.User;

public interface UserView extends View {
    void onGetUserClasses(List<ClassesUser> classesUsers);
    void onUser(UserPresenter presenter, User user);
    void onGeneratedClassesSuccess(User user, List<ClassesUser> classesUsers);

}
