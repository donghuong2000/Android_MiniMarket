package hcmute.edu.vn.mssv18110299.data.repository;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import hcmute.edu.vn.mssv18110299.RegisterActivity;
import hcmute.edu.vn.mssv18110299.data.Cart;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabase;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.dao.UserDao;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.utilities.Constants;
import hcmute.edu.vn.mssv18110299.utilities.ImageSaver;

public class UserRepository {

    private MiniMarketDatabase Dao;

    public UserRepository() {
         Dao = MiniMarketDatabaseApplication.GetDatabase();

    }

    public ResponseModel Login(String email, String password){
        // check user
        User user = Dao.userDao().GetUser(email);

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

    public  ResponseModel Register(String email, String password, String comparePassword,String bitmap){
        // validate input
        if(email.isEmpty() || password.isEmpty() || comparePassword.isEmpty() || bitmap.isEmpty())
            return new ResponseModel(false, "input cannot be empty");
        // compare password
        if(!password.equals(comparePassword))
            return new ResponseModel(false, "passwords don't match");
        // check if exits
        User user = Dao.userDao().GetUser(email);
        if(user != null){
            // ton tai user
            return new ResponseModel(false,"User already exists");
        }

        Dao.userDao().AddUser(new User(email,password,bitmap, Constants.User));
        user = Dao.userDao().GetUser(email);
        Dao.cartDao().AddCart(new Cart(user.getId()));
        return new ResponseModel(true,"Add user success");

    }

    public User GetUser(String username){
        return Dao.userDao().GetUser(username);
    }

    public ResponseModel UpdateUser(User user){
        try {
            Dao.userDao().updateUser(user);
            return new ResponseModel(true,"Update user info success");
        }
        catch (Exception ex){
            return new ResponseModel(false,ex.getMessage());
        }
    }
}
