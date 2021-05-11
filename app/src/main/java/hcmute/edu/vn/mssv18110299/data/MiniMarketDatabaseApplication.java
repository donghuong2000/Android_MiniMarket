package hcmute.edu.vn.mssv18110299.data;

import android.app.Application;

import androidx.room.Room;

public class MiniMarketDatabaseApplication extends Application {
    private static MiniMarketDatabase  miniMarketDatabase;


    @Override
    public void onCreate(){
        super.onCreate();
        // when upgrading versions, kill the original tables by using fallbackToDestructiveMigration()
        miniMarketDatabase = Room.databaseBuilder(this, MiniMarketDatabase.class,MiniMarketDatabase.NAME).fallbackToDestructiveMigration().build();
    }
    public static MiniMarketDatabase GetDatabase() {
        return  miniMarketDatabase;
    }

}
