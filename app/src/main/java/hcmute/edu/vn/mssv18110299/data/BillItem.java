package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"BillId","ItemId"},foreignKeys = {@ForeignKey(entity = Bill.class,parentColumns = "Id",childColumns = "BillId"),@ForeignKey(entity = Item.class,parentColumns = "Id",childColumns = "ItemId")})
public class BillItem {
    private int BillId;
    private int ItemId;
    private int Num;
    public BillItem(int billId, int itemId,int num) {
        BillId = billId;
        ItemId = itemId;
        Num = num;
    }
    public BillItem() {

    }

    public int getBillId() {
        return BillId;
    }

    public void setBillId(int billId) {
        BillId = billId;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }
}
