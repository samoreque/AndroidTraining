package avantica.training.com.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import avantica.training.com.myfirstapplication.Presenters.UserPresenter;
import avantica.training.com.myfirstapplication.models.ClassesUser;
import avantica.training.com.myfirstapplication.models.Project;
import avantica.training.com.myfirstapplication.models.User;
import avantica.training.com.myfirstapplication.retrofit.GithubAPI;
import avantica.training.com.myfirstapplication.views.UserView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements UserView, OptionFragment.OnFragmentInteractionListener {
    public static final String TAG="TrainingTag";
    InfromationFragment infoFragment;
    UserPresenter presenter;
    private GetUserClassesAsyncTask.IGetClassesUserListener listener = new GetUserClassesAsyncTask.IGetClassesUserListener() {
        @Override
        public void onGetClassesUser(List<ClassesUser> users) {
            Toast.makeText(MainActivity.this, "users classes: "+ users.size(), Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TrainingTag", "onCreate");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Fragment newFragment = OptionFragment.newInstance("", "");
        infoFragment = InfromationFragment.newInstance("","");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.lyContainer, newFragment);
        transaction.replace(R.id.lyContainerUp, infoFragment);

        transaction.addToBackStack(null);
        transaction.commit();
        MyFirstApplication.getInstance().setUser(new Person("Wilder", android.R.drawable.ic_media_next));

      /* Button btnWebView = findViewById(R.id.btnWebView);
        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
       });

        Button btnCall = findViewById(R.id.btnMakeACall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:(404)123-4567"));
                startActivity(i);
            }
        });

        Button btnGeo = findViewById(R.id.btnGeo);
        btnGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:54.1234,52.1234?z=22"));
                startActivity(i);
            }
        });*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MainActivity.this, AddPersonActivity.class);
                intent.putExtra(AddPersonActivity.PARAM_TITLE, "Add Person");
                intent.putExtra(AddPersonActivity.PARAM_AGE, 10);
                startActivity(intent);*/
                /*Fragment newFragment = InfromationFragment.newInstance("", "");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.lyContainer, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();*/
                Intent intentNewFriend = new Intent();
                intentNewFriend.setAction("avantica.training.com.myfirstapplication.ACTION_NEW_FRIEND");
                intentNewFriend.putExtra("name", "Avantica");
                //intentNewFriend.setPackage("avantica.training.com.myfirstapplication");
                sendBroadcast(intentNewFriend);

            }
        });
        getProjects();
        presenter = new UserPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        Log.d("TrainingTag", "onResume");
        super.onResume();
        new GetUserClassesAsyncTask(listener).execute(1);
    }


    @Override
    protected void onPause() {
        Log.d("TrainingTag", "onPause");
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {

        Log.d("TrainingTag", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onFragmentInteraction(String value) {
        Toast.makeText(this, "user pressed: " + value, Toast.LENGTH_SHORT).show();
        infoFragment.setMessage(value);
    }

    @Override
    public void startRecyclerExample(){
        Fragment newFragment = RecyclerFragment.newInstance("", "");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.lyContainerUp, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void getProjects() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubAPI.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        GithubAPI gitServices = retrofit.create(GithubAPI.class);
        Call<List<Project>> call = gitServices.getProjectList("Google");
        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                for (Project project : response.body()) {
                    Log.d("", project.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Log.e("", "Error getting projects", t);
            }
        });
    }

    @Override
    public void onGetUserClasses(List<ClassesUser> classesUsers) {

    }

    @Override
    public void onUser(UserPresenter presenter, User user) {
        Log.d(TAG, "user found " + user.getLogin());
        presenter.generateUserClasses(getApplicationContext(), user);

    }

    @Override
    public void onGeneratedClassesSuccess(User user, List<ClassesUser> classesUsers) {
        Toast.makeText(MainActivity.this, "Classes for "+ user.getLogin()+ " created ("
                + classesUsers.size() + ")", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Exception err) {

    }
}
