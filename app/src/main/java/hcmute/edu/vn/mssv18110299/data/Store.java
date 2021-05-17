package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Store {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Name;
    private float VotedScore;
    private String ImgUrl;
    private String Description;
    @Ignore
    private List<Item> Items;

    public Store(String Name,float VotedScore,String ImgUrl,String Description)
    {
        this.Id = 0;
        this.Name = Name;
        this.VotedScore = VotedScore;
        this.ImgUrl = ImgUrl;
        this.Description = Description;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public float getVotedScore() {
        return VotedScore;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setVotedScore(float votedScore) {
        VotedScore = votedScore;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }
}
