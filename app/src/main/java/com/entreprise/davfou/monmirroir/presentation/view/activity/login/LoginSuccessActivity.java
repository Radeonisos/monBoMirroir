package com.entreprise.davfou.monmirroir.presentation.view.activity.login;

/**
 * Created by davidfournier on 04/06/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;

import com.entreprise.davfou.monmirroir.presentation.view.activity.login.MenuActivity.MainActivity;
import com.entreprise.davfou.monmirroir.R;

public class LoginSuccessActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                startActivity(new Intent(LoginSuccessActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);



    }
}
