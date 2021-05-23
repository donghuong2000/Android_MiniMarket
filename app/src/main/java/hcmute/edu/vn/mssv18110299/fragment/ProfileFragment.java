package hcmute.edu.vn.mssv18110299.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import hcmute.edu.vn.mssv18110299.R;
import hcmute.edu.vn.mssv18110299.data.User;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView profile_display_name;
    private TextInputEditText profile_email,profile_name,profile_dob,profile_sex,profile_phone;
    private ImageView profile_avatar;
    private ImageSaver imageSaver;
    private User user;
    private Session session;



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
        //
        profile_display_name.setText(user.getName());
        profile_email.setText(user.getEmail());
        profile_dob.setText(String.valueOf(user.getDOB()));
        profile_sex.setText(user.getSex());
        profile_name.setText(user.getName());
        profile_phone.setText(user.getPhoneNumber());

        profile_avatar.setImageBitmap(imageSaver.load(user.getEmail()));
        return view;
    }
}