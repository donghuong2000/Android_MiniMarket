package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.List;

import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.Role;
import hcmute.edu.vn.mssv18110299.data.dao.RoleDao;

public class RoleRepository {

    private RoleDao roleDao;

    public RoleRepository(){
        roleDao = MiniMarketDatabaseApplication.GetDatabase().roleDao();
        // init
        List<Role> roles= roleDao.GetAllRoles();
        if(roles.size()==0)
        {
            roleDao.AddRole(new Role(1,"Admin"));
            roleDao.AddRole(new Role(2,"User"));
        }
    }

    public List<Role> GetListRole(){
        return roleDao.GetAllRoles();
    }


}
