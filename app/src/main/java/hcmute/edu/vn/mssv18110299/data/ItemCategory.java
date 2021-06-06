package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"ItemId","CategoryId"},foreignKeys = {@ForeignKey(entity = Item.class,parentColumns = "Id",childColumns = "ItemId"),@ForeignKey(entity = Category.class,parentColumns = "Id",childColumns = "CategoryId")})
public class ItemCategory {
    private int ItemId;
    private int CategoryId;

    public ItemCategory() {
    }

    public ItemCategory(int itemId, int categoryId) {
        ItemId = itemId;
        CategoryId = categoryId;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
}
