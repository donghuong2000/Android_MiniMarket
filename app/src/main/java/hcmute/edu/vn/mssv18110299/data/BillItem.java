package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"BillId","ItemId"},foreignKeys = {@ForeignKey(entity = Bill.class,parentColumns = "Id",childColumns = "BillId"),@ForeignKey(entity = Item.class,parentColumns = "Id",childColumns = "ItemId")})
public class BillItem {
    public int BillId;
    public int ItemId;
}
