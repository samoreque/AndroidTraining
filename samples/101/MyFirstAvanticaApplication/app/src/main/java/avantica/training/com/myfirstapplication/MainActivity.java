package avantica.training.com.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OptionFragment.OnFragmentInteractionListener {
    public static final String TAG="TrainingTag";
    InfromationFragment infoFragment;
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
                Fragment newFragment = InfromationFragment.newInstance("", "");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.lyContainer, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
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
}
