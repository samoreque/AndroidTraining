package avantica.training.com.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AddPersonActivity extends AppCompatActivity {

    public static final String PARAM_TITLE="titleApp";
    public static final String PARAM_AGE="age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        Bundle bundle = getIntent().getExtras();
        String title ="";
        int age =0;
        if(bundle != null) {
            title = bundle.getString(PARAM_TITLE, "default title "+15);
            age = bundle.getInt(PARAM_AGE, 0);
        }
        setTitle(title);
        ((EditText)findViewById(R.id.etxtAge)).setText(String.valueOf(age));

    }
}
