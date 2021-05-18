package hcmute.edu.vn.mssv18110299.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import hcmute.edu.vn.mssv18110299.MainActivity;

public class Session {
    private SharedPreferences prefs;
    private Context context;

    private static final String USER_NAME ="username";
    private static final String IS_LOGIN ="IS_LOGIN";
    public Session(Context context) {
        this.context = context;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setUsername(String usename) {
        prefs.edit().putString(USER_NAME, usename).commit();
        prefs.edit().putBoolean(IS_LOGIN,true).commit();
    }

    public String getUsername() {
        String usename = prefs.getString(USER_NAME,"");
        return usename;
    }
    public boolean isLoggedIn() {
        return prefs.getBoolean(IS_LOGIN,false);
    }
    public void checkLogging(){
        if(!isLoggedIn()){
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            context.startActivity(i);
        }
    }
}
