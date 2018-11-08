package avantica.training.com.myfirstapplication.Presenters;

import avantica.training.com.myfirstapplication.views.View;

public abstract class Presenter<T extends View> {
    private T view;
    public Presenter(T view) {
        this.view = view;
    }

    public abstract void initPresenter();

    public T getView() {
        return view;
    }
}
