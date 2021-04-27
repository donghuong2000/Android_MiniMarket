package hcmute.edu.vn.mssv18110299;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import hcmute.edu.vn.mssv18110299.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    MaterialButton resetPasswordBtn;
    TextInputEditText txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        txtEmail = findViewById(R.id.txtEmail);
        resetPasswordBtn = findViewById(R.id.resetPassword);
        resetPasswordBtn.setOnClickListener(x-> {
            String email = txtEmail.getText().toString();
            if(!email.isEmpty()) {
                Intent intent = new Intent(this, ForgotPasswordConfirmActivity.class);
                intent.putExtra("EXTRA_EMAIL", email);
                startActivity(intent);
            }
        });
    }

}