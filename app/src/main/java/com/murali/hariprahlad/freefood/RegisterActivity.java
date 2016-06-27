package com.murali.hariprahlad.freefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
        EditText re_name,re_email,re_mobile,re_password,re_pincode,re_address,re_city,re_area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.registertoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        re_name = (EditText)findViewById(R.id.reg_name);
        re_email = (EditText)findViewById(R.id.reg_email);
        re_mobile = (EditText)findViewById(R.id.reg_mobile);
        re_password = (EditText)findViewById(R.id.reg_password);
        re_pincode = (EditText)findViewById(R.id.reg_pincode);
        re_address = (EditText)findViewById(R.id.reg_address);
        re_city = (EditText)findViewById(R.id.reg_city);
        re_area = (EditText)findViewById(R.id.reg_area);

    }

    public void SignUp(View view){

    }
    public void SignIn(View view){
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
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
