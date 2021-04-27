package hcmute.edu.vn.mssv18110299;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.mssv18110299.R;

public class ForgotPasswordConfirmActivity extends AppCompatActivity {

    TextView timeDown;
    TextView resend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_confirm);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String email ="Please enter the 4 digit code send to " + intent.getStringExtra("EXTRA_EMAIL");
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.comfirm_text);
        timeDown = findViewById(R.id.timeCountDown);
        resend = findViewById(R.id.resend);
        resend.setOnClickListener(v->{
            SetTimeDown(60000,1000);
        });
        textView.setText(email);
        SetTimeDown(60000,1000);


    }
    public void SetTimeDown(Integer totalCount,Integer longCount){
        new CountDownTimer(totalCount, longCount) {

            public void onTick(long millisUntilFinished) {
                resend.setClickable(false);
                timeDown.setText(millisUntilFinished / 1000 +"s");
            }

            public void onFinish() {
                resend.setClickable(true);
            }
        }.start();
    }

}