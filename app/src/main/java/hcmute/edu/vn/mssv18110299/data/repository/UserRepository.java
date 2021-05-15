package hcmute.edu.vn.mssv18110299.data.repository;

import android.os.AsyncTask;
import android.util.Log;

import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.dao.UserDao;

public class UserRepository {

    public UserDao userDao;

    public UserRepository()
    {
        userDao = MiniMarketDatabaseApplication.GetDatabase().userDao();
    }

    public boolean Login(String email,String password){
        // check user
        User user = userDao.GetUser(email);

        if(user != null){
            //ton tai
            if(user.Password == password){
                Log.d("LoginStatus","Login Success");
                return true;
            }
            Log.d("LoginStatus","Login Fail");
            return false;
        }
        Log.d("LoginStatus","User Null: "+email);
        return false;
    }

    public  boolean Register(User user){
        // check if exits
        User u = userDao.GetUser(user.Email);
        if(u != null){ // ton tai user
            Log.d("RegisterStatus","User Exits");
            return false;
        }
        else {
            userDao.AddUser(user);
            Log.d("RegisterStatus","User Create");
            return true;
        }
    }
}
