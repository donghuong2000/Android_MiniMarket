package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.User;

@Dao
public interface UserDao {

    // insert user
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddUser(User user);
    // get all user
    @Query(value = "SELECT * FROM User ORDER BY Id")
    List<User> GetAllUsers();
    // get  user by id
    @Query(value = "SELECT * FROM User WHERE Id =:id")
    User GetUser(int id);
    // get  user by Mail
    @Query(value = "SELECT * FROM User WHERE Email=:mail")
    User GetUser(String mail);
    // update user
    @Update
    void updateUser(User... users);
    // delete user
    @Delete
    void DeleteUser(User user);
}
