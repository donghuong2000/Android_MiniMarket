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
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface UserDao {

    // insert user
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable AddUser(User user);
    // get all user
    @Query(value = "SELECT * FROM User ORDER BY Id")
    LiveData<List<User>> GetAllUsers();
    // get  user by id
    @Query(value = "SELECT * FROM User WHERE Id =:id")
    LiveData<User> GetUser(int id);
    // get  user by Mail
    @Query(value = "SELECT * FROM User WHERE Email=:mail")
    Single<User> GetUser(String mail);
    // update user
    @Update
    Completable updateUser(User... users);
    // delete user
    @Delete
    Completable DeleteUser(User user);
}
