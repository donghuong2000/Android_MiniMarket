package hcmute.edu.vn.mssv18110299.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.Bill;


@Dao
public interface  BillDao {
    // insert Bill
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddBill(Bill Bill);
    // get all Bill
    @Query(value = "SELECT * FROM Bill ORDER BY Id")
    List<Bill> GetAllBills();
    // get Bill by id
    @Query(value = "SELECT * FROM Bill WHERE Id =:id")
    Bill GetBill(int id);

    @Query(value = "SELECT * FROM Bill WHERE UserId =:id")
    List<Bill> GetBillByUserId(int id);
    // Bill Bill
    @Update
    void updateBill(Bill... Bill);
    // delete Bill
    @Delete
    void DeleteBill(Bill Bill);
}
