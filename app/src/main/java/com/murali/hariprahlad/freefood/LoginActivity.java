package com.murali.hariprahlad.freefood;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText login_email,login_password,login_forgotpassword;
    String Email,Password,ForgotPassword;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //this methode for hididng keyboard untill we touch the screen
        hideKeyboard();

        Toolbar toolbar = (Toolbar)findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_mobile);
        login_forgotpassword = (EditText)findViewById(R.id.forgot_password);
        ForgotPassword = login_forgotpassword.getText().toString();
    }
    public void SignUp(View view){
        Intent signUp = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(signUp);
        }
    public void SignIn(View view){
//        Email = login_email.getText().toString();
//        Password = login_password.getText().toString();
//
//            if(Email.isEmpty()){
//                login_email.setError("You need to enter a Email");
//            }
//            else if(Password.isEmpty()){
//                login_password.setError("You need to enter a Password");
//            }
//        else {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
        finish();
//            }
        }
    public void ForgotPassword(View view){
                View forgotLayout = findViewById(R.id.forgotlayout);
                forgotLayout.setAnimation(AnimationUtils.makeInChildBottomAnimation(getApplicationContext()));
                forgotLayout.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.login_form).setVisibility(View.GONE);
                    }
                }, 500);
    }
    public void CancelLayout(View view){
                View forgotLayout = findViewById(R.id.login_form);
                forgotLayout.setAnimation(AnimationUtils.makeInChildBottomAnimation(getApplicationContext()));
                forgotLayout.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.forgotlayout).setVisibility(View.GONE);
                    }
                }, 500);
    }
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();

            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
