package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Store.class, parentColumns = "Id", childColumns = "StoreId"),
                        @ForeignKey(entity = Brand.class,parentColumns = "Id",childColumns = "BrandId")})
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Name;
    private float Price;
    private float VotedScore;
    private int Amount;
    private String ImgUrl;
    private String Description;
    private int StoreId;
    private int BrandId;

    public Item(){

    }
    public Item(String name, float price, float votedScore, int amount, String imgUrl, String description, int storeId, int brandId) {
        Name = name;
        Price = price;
        VotedScore = votedScore;
        Amount = amount;
        ImgUrl = imgUrl;
        Description = description;
        StoreId = storeId;
        BrandId = brandId;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getVotedScore() {
        return VotedScore;
    }

    public void setVotedScore(float votedScore) {
        VotedScore = votedScore;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        BrandId = brandId;
    }
}
