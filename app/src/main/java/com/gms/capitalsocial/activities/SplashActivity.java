package com.gms.capitalsocial.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gms.capitalsocial.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (savedInstanceState == null) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Intent act = new Intent(context, LogInActivity.class);
                            startActivity(act);
                        }
                    });
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, 5000);
        } else {
            Intent act = new Intent(context, MainActivity.class);
            startActivity(act);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}
