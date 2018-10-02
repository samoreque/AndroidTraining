package avantica.training.com.myfirstapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Tag", "My action " + intent.getAction());
        String name ="";
        if (intent.hasExtra("name")) name = intent.getExtras().getString("name");
        Toast.makeText(context, "getAction " + intent.getAction() + " " + name, Toast.LENGTH_SHORT).show();
    }
}
