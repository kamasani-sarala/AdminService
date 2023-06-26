package com.adminservice.service;

import java.util.List;

import com.adminservice.entity.Admin;
import com.adminservice.exception.AdminAlreadyExist;
import com.adminservice.exception.AdminNotFound;


public interface AdminService {
	public List<Admin> getAllAdmin();
	public Admin addAdmin(Admin admin) throws AdminAlreadyExist;
    public Admin updateAdmin(Admin admin) throws AdminNotFound;
    
	public void addAdmink(Admin admin) throws AdminAlreadyExist;
	public Admin getadminById(Integer adminId) throws AdminNotFound;
	public void updateadmin(Admin admin);
	
}

