package com.adminservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adminservice.entity.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer> {
  
}