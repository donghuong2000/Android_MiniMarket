package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"ItemId","CategoryId"},foreignKeys = {@ForeignKey(entity = Item.class,parentColumns = "Id",childColumns = "ItemId"),@ForeignKey(entity = Category.class,parentColumns = "Id",childColumns = "CategoryId")})
public class ItemCategory {
    public int ItemId;
    public  int CategoryId;
}
