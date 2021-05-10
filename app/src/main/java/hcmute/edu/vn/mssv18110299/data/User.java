package hcmute.edu.vn.mssv18110299.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity()
public class User {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;
    public String Email;
    public String Sex;
    public Date DOB;
    public String PhoneNumber;
    public String Password;
    public String AvatarImageUrl;
}
