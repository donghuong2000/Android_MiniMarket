package hcmute.edu.vn.mssv18110299;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import hcmute.edu.vn.mssv18110299.data.repository.UserRepository;

public class  MainActivity extends AppCompatActivity {

    UserRepository userRepository;
    TextView ForgotPasswordBtn;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userRepository = new UserRepository();
        Button btnSignIn = findViewById(R.id.btnSignIn);
        username = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        TextView btnSignUp = findViewById(R.id.btnSignUpLogin);
        btnSignIn.setOnClickListener(x->{
            new Login(this,username.getText().toString(),password.getText().toString()).execute();
        });
        btnSignUp.setOnClickListener(v-> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    public void Forgot_Button_OnClick(View v){
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void SignUp_Button_OnClick(View v){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    private void DisplayText(boolean aBoolean)
    {

    }
    private static class Login extends AsyncTask<Void,Void,Boolean> {


        private WeakReference<MainActivity> activityReference;
        private String Username;
        private String Password;
        // only retain a weak reference to the activity
        Login(MainActivity context, String username,String password) {
            activityReference = new WeakReference<>(context);
            Username = username;
            Password = password;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            boolean success =   activityReference.get().userRepository.Login(Username,Password);
           return  success;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            // intent home Page If Success TODO
            if(aBoolean){
                Toast.makeText(activityReference.get(),"oke thanh cong",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(activityReference.get(), "oke that bai cmnr thanh cong", Toast.LENGTH_LONG).show();
            }
            }
        }
}

