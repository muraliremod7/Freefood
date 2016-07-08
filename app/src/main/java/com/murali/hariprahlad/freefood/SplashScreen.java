package com.murali.hariprahlad.freefood;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;


public class SplashScreen extends AppCompatActivity {
    String registrationStatus, user_type;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences settings_prefs = getSharedPreferences(
                "login_info_new", MODE_PRIVATE);
        registrationStatus = settings_prefs.getString(
                "is_registration_done", "no");

        final int welcomeScreenDisplay = 3000;
        /** create a thread to show splash up to splash time */
        Thread welcomeThread = new Thread() {
            int wait = 0;

            @Override
            public void run() {
                try {
                    super.run();
                    /**
                     * use while to get the splash time. Use sleep() to increase
                     * the wait variable for every 100L.
                     */
                    while (wait < welcomeScreenDisplay) {
                        sleep(100);
                        wait += 100;
                    }
                } catch (Exception e) {
                    System.out.println("EXc=" + e);
                } finally {

                    if (registrationStatus.equalsIgnoreCase("yes")) {
                        Intent user_details_intent = new Intent(
                                getApplicationContext(), LoginActivity.class);
                        startActivity(user_details_intent);
                        finish();
                    }  else {
                        Intent login_intent = new Intent(
                                getApplicationContext(), LoginActivity.class);
                        startActivity(login_intent);
                        finish();
                    }

                }
            }
        };
        welcomeThread.start();

    }
//    private void addShortcut() {
//        //Adding shortcut for com.murali.hariprahlad.MainActivity
//        //on Home screen
//        Intent shortcutIntent = newone Intent(getApplicationContext(), SplashActivity.class);
//
//        shortcutIntent.setAction(Intent.ACTION_MAIN);
//
//        Intent addIntent = newone Intent();
//        addIntent
//                .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "WalletbabShortcut");
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
//                Intent.ShortcutIconResource.fromContext(getApplicationContext(),
//                        R.drawable.menupic));
//
//        addIntent
//                .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
//        getApplicationContext().sendBroadcast(addIntent);
//    }
}
