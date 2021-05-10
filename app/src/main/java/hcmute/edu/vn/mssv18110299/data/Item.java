package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Store.class, parentColumns = "Id", childColumns = "StoreId"))
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;
    public Float Price;
    public Float VotedScore;
    public int Amount;
    public String ImgUrl;
    public String Description;
    public int StoreId;
}
