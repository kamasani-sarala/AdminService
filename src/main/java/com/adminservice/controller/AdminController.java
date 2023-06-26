package com.adminservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.entity.Admin;
import com.adminservice.exception.AdminAlreadyExist;
import com.adminservice.exception.AdminNotFound;
import com.adminservice.service.AdminService;



@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/login")
	public List<Admin> getAllAdmin() {
		return this.adminservice.getAllAdmin();
	}
	
	@GetMapping("/register/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("adminId") Integer adminId) throws AdminNotFound{
        return new ResponseEntity<Admin>(adminservice.getadminById(adminId),HttpStatus.OK);
    }
	
	@PostMapping("/register")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin) throws AdminAlreadyExist{
         this.adminservice.addAdmin(admin);
         return new ResponseEntity<>("Admin ID Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/customercare")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) throws AdminNotFound{
         this.adminservice.updateadmin(admin);
         return new ResponseEntity<>("Feedback Updated Successfully", HttpStatus.OK);
    }
}

