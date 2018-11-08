package avantica.training.com.myfirstapplication.Respositories;

import avantica.training.com.myfirstapplication.DataSources.DataSource;

public abstract class Repository <T extends DataSource> {
    private T dataSource;
    public Repository (T dataSource) {
        this.dataSource = dataSource;
    }

    public T getDataSource() {
        return dataSource;
    }
}
