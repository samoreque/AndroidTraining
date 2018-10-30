package avantica.training.com.myfirstapplication.retrofit;

import java.util.List;

import avantica.training.com.myfirstapplication.models.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {
    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Call<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
