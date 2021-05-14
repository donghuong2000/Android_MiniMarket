package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity( primaryKeys = {"ItemId","CartId"},
         foreignKeys = {
                @ForeignKey(entity = Cart.class,parentColumns = "Id",childColumns = "CartId"),
                @ForeignKey(entity = Item.class, parentColumns = "Id",childColumns = "ItemId")})
public class CartItem {

    public int ItemId;
    public int CartId;
}
