package com.vk.service;

import java.util.List;

import com.vk.dto.Admin;

public interface AdminService {

	public Admin saveAdmin(Admin p);

	public Admin findAdminById(int id);

	public List<Admin> findAllAdmins();

	public boolean updateAdminById(int id, Admin p);
}
