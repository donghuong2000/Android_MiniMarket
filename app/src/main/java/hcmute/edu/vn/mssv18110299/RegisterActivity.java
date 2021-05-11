package hcmute.edu.vn.mssv18110299;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.repository.UserRepository;

public class RegisterActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    UserRepository userRepository;
    ImageView avatar;
    ImageView camera;
    EditText username,password,confirmPassword;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userRepository = new UserRepository();
        avatar = findViewById(R.id.avatar);
        camera = findViewById(R.id.camera);
        username = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        confirmPassword = findViewById(R.id.txtConfirmPassword);
        signIn = findViewById(R.id.btnSignUp);
        camera.setOnClickListener(v-> dispatchTakePictureIntent());
        signIn.setOnClickListener(v-> {
            if(Validate()) {
                User user = new User();
                user.Email = username.getText().toString();
                user.Password = password.getText().toString();
                new Register(this,user).execute();
            }
        });




    }
    private boolean Validate() {
        String cp,p;
        p = password.getText().toString();
        cp = confirmPassword.getText().toString();
        if(!p.equals(cp))
            return  false;// display Error TODO
        if(username.getText().toString().length()<5)
            return false;
        if(password.getText().toString().length()<5)
            return false;

        return true;

    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            avatar.setImageBitmap(imageBitmap);
        }

    }
    private static class Register extends AsyncTask<Void,Void,Boolean> {


        private WeakReference<RegisterActivity> activityReference;
        private User user;
        // only retain a weak reference to the activity
        Register(RegisterActivity context, User user) {
            activityReference = new WeakReference<>(context);
            this.user = user;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean success = activityReference.get().userRepository.Register(user);
            return  success;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            // intent home Page If Success TODO
            if(aBoolean){
                Toast.makeText(activityReference.get(),"Dang ki thanh cong",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(activityReference.get(), "Dang ki that bai", Toast.LENGTH_LONG).show();
            }
        }
    }
}
