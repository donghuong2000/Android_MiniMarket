package hcmute.edu.vn.mssv18110299.data.repository;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.dao.UserDao;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.utilities.Constants;

public class UserRepository {

    private UserDao userDao;

    public UserRepository() {
        userDao = MiniMarketDatabaseApplication.GetDatabase().userDao();
    }

    public ResponseModel Login(String email, String password){
        // check user
        User user = userDao.GetUser(email);

        if(user != null){
            //ton tai
            if(user.getPassword().equals(password) ){
                return new ResponseModel(true,"Login is Success");
            }
            Log.d("LoginStatus","Login Fail");
            return new ResponseModel(false, "wrong username or password");
        }
        else {
            return new ResponseModel(false, "User does not exist");
        }
    }

    public  ResponseModel Register(String email,String password,String comparePassword){
        // validate input
        if(email.isEmpty() || password.isEmpty() || comparePassword.isEmpty() )
            return new ResponseModel(false, "input cannot be empty");
        // compare password
        if(!password.equals(comparePassword))
            return new ResponseModel(false, "passwords don't match");
        // check if exits
        User user = userDao.GetUser(email);
        if(user != null){
            // ton tai user
            return new ResponseModel(false,"User already exists");
        }

        userDao.AddUser(new User(email,password, Constants.User));
        return new ResponseModel(true,"Add user success");

    }




}
