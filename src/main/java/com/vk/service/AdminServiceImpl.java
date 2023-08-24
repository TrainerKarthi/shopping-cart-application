package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.dao.AdminDao;
import com.vk.dto.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao ;

	public Admin saveAdmin(Admin p) {
		return adminDao.saveAdmin(p) ;
	}

	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> findAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateAdminById(int id, Admin p) {
		// TODO Auto-generated method stub
		return false;
	}

}
