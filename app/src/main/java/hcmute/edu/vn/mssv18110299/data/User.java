package hcmute.edu.vn.mssv18110299.data;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import hcmute.edu.vn.mssv18110299.utilities.DateConverter;

@Entity(foreignKeys = {@ForeignKey(entity = Role.class,parentColumns = "Id",childColumns = "RoleId")})
public class User {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Name;
    private String Email;
    private String Sex;
    @TypeConverters({DateConverter.class})
    private Date DOB;
    private String PhoneNumber;
    private String Password;
    private String AvatarImageUrl;
    private boolean IsActive;
    private int RoleId;


    public User() {
    }

    public User(String name, String email, String sex, Date DOB, String phoneNumber, String password, String avatarImageUrl, boolean isActive, int roleId) {
        Name = name;
        Email = email;
        Sex = sex;
        this.DOB = DOB;
        PhoneNumber = phoneNumber;
        Password = password;
        AvatarImageUrl = avatarImageUrl;
        IsActive = isActive;
        RoleId = roleId;
    }

    public User(String email, String password, int roleId) {
        Email = email;
        Password = password;
        RoleId = roleId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAvatarImageUrl() {
        return AvatarImageUrl;
    }

    public void setAvatarImageUrl(String avatarImageUrl) {
        AvatarImageUrl = avatarImageUrl;
    }

    public boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean active) {
        IsActive = active;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }
}
