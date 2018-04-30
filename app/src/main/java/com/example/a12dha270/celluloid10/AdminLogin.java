package com.example.a12dha270.celluloid10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a12dha270.celluloid10.Preference.LoginPreferences;

public class AdminLogin extends AppCompatActivity {
    private EditText usernameET, passET;
    private LoginPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        usernameET = findViewById(R.id.adminUsername);
        passET = findViewById(R.id.adminPassword);
        preferences = new LoginPreferences(this);

        if (preferences.getStatus()){
            startActivity(new Intent(AdminLogin.this,MovieList.class));
            Toast.makeText(this, "Already Logged!!", Toast.LENGTH_SHORT).show();
        }

    }
    public void loginAdmin(View view) {
        String email = usernameET.getText().toString();
        String pass = passET.getText().toString();
        if (email.isEmpty()){
            usernameET.setError("Please enter your username");
            return;
        }
        if (pass.isEmpty()){
            passET.setError("Please enter your password");
            return;
        }
        if(email.equals(preferences.getAdminUsername()) && pass.equals(preferences.getAdminPassword())){
            preferences.setStatus(true);
            startActivity(new Intent(AdminLogin.this,MovieList.class));
        }else{
            Toast.makeText(this, "invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerAdmin(View view) {
        String username = usernameET.getText().toString();
        String pass = passET.getText().toString();
        if (username.isEmpty()){
            usernameET.setError("Please enter your username");
            return;
        }
        if (pass.isEmpty()){
            passET.setError("Please enter your password");
            return;
        }
        String msg = preferences.registerAdmin(username,pass);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AdminLogin.this,MovieList.class));
    }
}