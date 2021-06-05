package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = User.class,parentColumns = "Id",childColumns = "Id"))
public class Cart {
    @PrimaryKey
    public int Id;

    public Cart(int id) {
        Id = id;
    }

    public Cart() {
    }
}
