package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import hcmute.edu.vn.mssv18110299.utilities.DateConverter;

@Entity(foreignKeys = @ForeignKey(entity = User.class,parentColumns = "Id",childColumns = "UserId" ))
public class Bill {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private int UserId;
    @TypeConverters({DateConverter.class})
    private Date DateCreate;
    private float Total;

    public Bill() {
    }

    public Bill(int id, int userId, Date dateCreate, float total) {
        Id = id;
        UserId = userId;
        DateCreate = dateCreate;
        Total = total;

    }

    public Bill(int userId, float total) {
        UserId = userId;
        Total = total;
        DateCreate = new Date();
    }
    public Bill(int userId) {
        UserId = userId;
        DateCreate = new Date();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }
}
