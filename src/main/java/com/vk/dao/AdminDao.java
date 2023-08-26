package com.vk.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.vk.dto.Admin;

public interface AdminDao {
	public Admin saveAdmin(Admin p);

	public Admin findAdminById(int id);

	public List<Admin> findAllAdmins();

	public boolean updateAdminById(int id, Admin p);

	public boolean findByEmailAndPassword(String email,String password, HttpSession session) ;
}
