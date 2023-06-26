package com.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.dao.AdminDAO;
import com.adminservice.entity.Admin;
import com.adminservice.exception.AdminAlreadyExist;
import com.adminservice.exception.AdminNotFound;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDao;

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.findAll();
    }

    @Override
	public Admin addAdmin(Admin admin) throws AdminAlreadyExist {
    	if (adminDao.findById(admin.getAdminId()).isEmpty()) {
            adminDao.save(admin);
            return admin;
            }
            else {
                throw new AdminAlreadyExist();
            }
	}


	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFound {
		if(adminDao.findById(admin.getAdminId()).isEmpty()) {
            adminDao.save(admin);
            throw new AdminNotFound();
        }
        else {
            adminDao.save(admin);
        return admin;
        }
    }


	@Override
	public Admin getadminById(Integer adminId) throws AdminNotFound {
		Admin a;
        if(adminDao.findById(adminId).isEmpty()) {
            throw new AdminNotFound();
        }
        else {
            a=adminDao.findById(adminId).get();
        }
        return a;
    }

	@Override
	public void addAdmink(Admin admin) throws AdminAlreadyExist {
		
		
	}

	@Override
	public void updateadmin(Admin admin) {
		
		
	}
}




	