package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.mssv18110299.data.Bill;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabase;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.User;

public class BillRepository {
    private MiniMarketDatabase db;

    public BillRepository(){
        db = MiniMarketDatabaseApplication.GetDatabase();
    }
    public ArrayList<Bill> GetAllBillByUserId(int id){
        List<Bill> bills =  db.billDao().GetBillByUserId(id);
        return new ArrayList<>(bills);
    }
    public ArrayList<Bill> GetAllBillByUserName(String username){

        User user = db.userDao().GetUser(username);
        List<Bill> bills =  db.billDao().GetBillByUserId(user.getId());
        return new ArrayList<>(bills);
    }
}
