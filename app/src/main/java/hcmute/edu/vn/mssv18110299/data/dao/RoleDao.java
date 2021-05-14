package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.BillItem;
import hcmute.edu.vn.mssv18110299.data.Brand;
import hcmute.edu.vn.mssv18110299.data.Role;


@Dao
public interface RoleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddRole(Role Role);

    @Query(value = "SELECT * FROM Role")
    List<Role> GetAllRoles();

    @Query(value = "SELECT * FROM Role WHERE Id =:Id")
    Role GetRole(int Id);

    @Update
    void updateRole(Role... Role);

    @Delete
    void DeleteRole(Role Role);
}
