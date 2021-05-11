package hcmute.edu.vn.mssv18110299.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import hcmute.edu.vn.mssv18110299.utilities.DateConverter;

@Entity()
public class User {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;
    public String Email;
    public String Sex;
    @TypeConverters({DateConverter.class})
    public Date DOB;
    public String PhoneNumber;
    public String Password;
    public String AvatarImageUrl;

    public User(){
    }
}
