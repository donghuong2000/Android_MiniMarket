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


@Dao
public interface BrandDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void AddBrand(BillItem BillItem);

    @Query(value = "SELECT * FROM Brand")
    List<Brand> GetAllBrands();

    @Query(value = "SELECT * FROM Brand WHERE Id =:Id")
    Brand GetBrand(int Id);

    @Update
    void updateBrand(Brand... Brand);

    @Delete
    void DeleteBrand(Brand Brand);
}
