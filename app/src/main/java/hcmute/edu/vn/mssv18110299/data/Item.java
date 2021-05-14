package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Store.class, parentColumns = "Id", childColumns = "StoreId"),
                        @ForeignKey(entity = Brand.class,parentColumns = "Id",childColumns = "BrandId")})
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;
    public float Price;
    public float VotedScore;
    public int Amount;
    public String ImgUrl;
    public String Description;
    public int StoreId;
    public int BrandId;
}
