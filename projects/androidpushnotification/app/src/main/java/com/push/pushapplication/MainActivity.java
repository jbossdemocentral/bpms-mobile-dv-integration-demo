package com.push.pushapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.jboss.aerogear.android.core.Callback;
import org.jboss.aerogear.android.unifiedpush.MessageHandler;
import org.jboss.aerogear.android.unifiedpush.PushRegistrar;
import org.jboss.aerogear.android.unifiedpush.RegistrarManager;
import org.jboss.aerogear.android.unifiedpush.gcm.UnifiedPushMessage;

public class MainActivity extends AppCompatActivity implements MessageHandler {

    private static final String TAG = "Push App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PushApplication application = (PushApplication) getApplication();
        PushRegistrar pushRegistar = application.getPushRegistar();
        pushRegistar.register(getApplicationContext(), new Callback<Void>() {
            @Override
            public void onSuccess(Void data) {
                Log.d(TAG, "Registration Succeeded");
                Toast.makeText(getApplicationContext(),
                        "Yay, Device registered", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, e.getMessage(), e);
                Toast.makeText(getApplicationContext(),
                        "Ops, something is wrong :("+getApplicationContext(), Toast.LENGTH_LONG).show();
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
        super.onResume();
        RegistrarManager.registerMainThreadHandler(this); // 1
        RegistrarManager.unregisterBackgroundThreadHandler(NotifyingHandler.instance);
    }

    @Override
    protected void onPause() {
        super.onPause();
        RegistrarManager.unregisterMainThreadHandler(this); // 2
        RegistrarManager.registerBackgroundThreadHandler(NotifyingHandler.instance);
    }

    @Override
    public void onMessage(Context context, Bundle bundle) {
        // display the message contained in the payload
        TextView text = (TextView) findViewById(R.id.label);
        text.setText(bundle.getString(UnifiedPushMessage.ALERT_KEY)); // 3
    }

    @Override
    public void onDeleteMessage(Context context, Bundle message) {
        // handle GoogleCloudMessaging.MESSAGE_TYPE_DELETED
    }

    @Override
    public void onError() {
        // handle GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
    }
}
