package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity( primaryKeys = {"ItemId","CartId"},
         foreignKeys = {
                @ForeignKey(entity = Cart.class,parentColumns = "Id",childColumns = "CartId"),
                @ForeignKey(entity = Item.class, parentColumns = "Id",childColumns = "ItemId")})
public class CartItem {

    private int ItemId;
    private int CartId;
    private int Num;
    @Ignore
    private Item Item;
    @Ignore
    private Cart Cart;


    public CartItem(){}
    public CartItem(int itemId, int cartId, int num) {
        ItemId = itemId;
        CartId = cartId;
        Num = num;
    }

    public CartItem(int itemId, int cartId, int num, hcmute.edu.vn.mssv18110299.data.Item item) {
        ItemId = itemId;
        CartId = cartId;
        Num = num;
        Item = item;

    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public hcmute.edu.vn.mssv18110299.data.Item getItem() {
        return Item;
    }

    public void setItem(hcmute.edu.vn.mssv18110299.data.Item item) {
        Item = item;
    }

    public hcmute.edu.vn.mssv18110299.data.Cart getCart() {
        return Cart;
    }

    public void setCart(hcmute.edu.vn.mssv18110299.data.Cart cart) {
        Cart = cart;
    }
}
