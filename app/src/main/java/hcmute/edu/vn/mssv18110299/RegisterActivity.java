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
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.data.repository.UserRepository;
import hcmute.edu.vn.mssv18110299.utilities.ImageSaver;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class RegisterActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    UserRepository userRepository;
    ImageView avatar;
    ImageView camera;
    EditText username,password,confirmPassword;
    Button signIn;
    Session session;
    ImageSaver imageSaver;
    Bitmap avatarBitmap;
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
        signIn.setOnClickListener(v-> Validate());
        session = new Session(this);
        imageSaver = new ImageSaver(this);
        avatarBitmap = null;
    }
    private void Validate() {
        String avatarImage = "";
        if(avatarBitmap!=null){
            imageSaver.save(avatarBitmap,username.getText().toString());
            avatarImage = username.getText().toString();
        }
        ResponseModel response = userRepository.Register(username.getText().toString(),password.getText().toString(),confirmPassword.getText().toString(),avatarImage);
        if(response.isSuccess)
        {
            session.setUsername(username.getText().toString());
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,response.message,Toast.LENGTH_LONG).show();
        }
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
            avatarBitmap = (Bitmap) extras.get("data");
            avatar.setImageBitmap(avatarBitmap);
        }

    }

}
