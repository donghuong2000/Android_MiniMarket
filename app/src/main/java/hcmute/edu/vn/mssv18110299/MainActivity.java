package hcmute.edu.vn.mssv18110299;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.dao.UserDao;
import hcmute.edu.vn.mssv18110299.data.repository.UserRepository;
import io.reactivex.rxjava3.core.Single;

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
           userRepository.Login(username.getText().toString(),password.getText().toString());
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


}

