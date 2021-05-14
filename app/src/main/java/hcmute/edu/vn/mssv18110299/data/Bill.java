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
    public int Id;
    public int UserId;
    @TypeConverters({DateConverter.class})
    public Date DateCreate;
    public float Total;
}
