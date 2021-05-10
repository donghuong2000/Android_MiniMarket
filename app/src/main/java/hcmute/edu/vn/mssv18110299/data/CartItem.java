package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = { @ForeignKey(entity = Cart.class,parentColumns = "Id",childColumns = "CartId"), @ForeignKey(entity = Item.class, parentColumns = "Id",childColumns = "ItemId")})
public class CartItem {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public int ItemId;
    public int CartId;
}
