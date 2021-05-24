package hcmute.edu.vn.mssv18110299.fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.data.repository.UserRepository;
import hcmute.edu.vn.mssv18110299.utilities.ImageSaver;
import hcmute.edu.vn.mssv18110299.utilities.Session;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView profile_display_name;
    private TextInputEditText profile_email,profile_name,profile_dob,profile_sex,profile_phone;
    private ImageView profile_avatar,profile_camera;
    private ImageSaver imageSaver;
    private User user;
    private Session session;
    private Bitmap avatarBm;
    private MaterialButton update_profile_btn;




    public ProfileFragment() {
        // Required empty public constructor


    }


    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        session = new Session(getContext());
        imageSaver = new ImageSaver(getContext());
        user = new UserRepository().GetUser(session.getUsername());
        avatarBm = null;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_display_name = view.findViewById(R.id.profile_display_name);
        profile_email = view.findViewById(R.id.profile_email);
        profile_dob = view.findViewById(R.id.profile_dob);
        profile_sex = view.findViewById(R.id.profile_sex);
        profile_name = view.findViewById(R.id.profile_name);
        profile_phone = view.findViewById(R.id.profile_phone);
        profile_avatar = view.findViewById(R.id.profile_avatar);
        update_profile_btn = view.findViewById(R.id.profile_update);
        profile_camera = view.findViewById(R.id.profile_camera);
        //
        profile_display_name.setText(user.getName());
        profile_email.setText(user.getEmail());
        profile_dob.setText(String.valueOf(user.getDOB()));
        profile_sex.setText(user.getSex());
        profile_name.setText(user.getName());
        profile_phone.setText(user.getPhoneNumber());
        update_profile_btn.setOnClickListener(v->Update_Profile());
        profile_avatar.setImageBitmap(imageSaver.load(user.getEmail()));
        profile_camera.setOnClickListener(v-> dispatchTakePictureIntent());
        return view;
    }


    public void Update_Profile() {
        user.setName(profile_name.getText().toString());
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        ParsePosition pp1 = new ParsePosition(0);
        user.setDOB(formatter.parse(profile_dob.getText().toString(),pp1));
        user.setSex(profile_sex.getText().toString());
        user.setPhoneNumber(profile_phone.getText().toString());
        imageSaver.save(avatarBm,user.getEmail());
        ResponseModel md = new UserRepository().UpdateUser(user);
        Toast.makeText(getContext(),md.message,Toast.LENGTH_LONG).show();
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == -1) {
            Bundle extras = data.getExtras();
            avatarBm = (Bitmap) extras.get("data");
            profile_avatar.setImageBitmap(avatarBm);
        }

    }

}