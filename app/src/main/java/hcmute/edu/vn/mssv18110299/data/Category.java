package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;


}
