package com.example.a12dha270.celluloid10.Preference;

import android.content.Context;
import android.content.SharedPreferences;


public class LoginPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String ADMIN_USERNAME = "admin_username";
    private static final String ADMIN_PASSWORD = "admin_password";
    private static final String ISLOGGEDIN = "isLoggedIn";
    private static final String DEFAULT_MESSAGE = "User not found";


    public LoginPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public String registerAdmin(String username, String pass){
        editor.putString(ADMIN_USERNAME,username);
        editor.putString(ADMIN_PASSWORD,pass);
        editor.commit();

        return "Registered Successfully";
    }

    public String getAdminUsername() {
        return sharedPreferences.getString(ADMIN_USERNAME,DEFAULT_MESSAGE);
    }

    public String getAdminPassword() {
        return sharedPreferences.getString(ADMIN_PASSWORD,DEFAULT_MESSAGE);
    }

    public void setStatus(boolean status){
        editor.putBoolean(ISLOGGEDIN,status);
        editor.commit();
    }

    public boolean getStatus(){

        return sharedPreferences.getBoolean(ISLOGGEDIN,false);
    }

}
