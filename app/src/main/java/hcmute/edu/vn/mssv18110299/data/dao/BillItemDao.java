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
import hcmute.edu.vn.mssv18110299.data.BillItem;


@Dao
public interface BillItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddBillItem(BillItem BillItem);

    @Query(value = "SELECT * FROM BillItem")
    List<BillItem> GetAllBillItem();

    @Query(value = "SELECT * FROM BillItem WHERE BillId =:BillId")
    BillItem GetBillItem(int BillId);

    @Update
    void updateBill(BillItem... BillItem);

    @Delete
    void DeleteBill(BillItem BillItem);
}
