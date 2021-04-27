package hcmute.edu.vn.mssv18110299;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import hcmute.edu.vn.mssv18110299.R;

public class MainActivity extends AppCompatActivity {


    TextView ForgotPasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public  void Forgot_Button_OnClick(View v){
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public  void SignUp_Button_OnClick(View v){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}