package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Store {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;
    public Float VotedScore;
    public String ImgUrl;
    public String Description;
}
