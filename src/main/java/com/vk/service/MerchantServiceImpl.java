package com.vk.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.vk.dao.MerchantDao;
import com.vk.dto.Merchant;

public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantDao merchantDao ;
	public Merchant saveMerchant(Merchant p) {
		merchantDao.saveMerchant(p) ;
		return p ;
	}

	public Merchant findMerchantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Merchant> findAllMerchants() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateMerchantById(int id, Merchant p) {
		// TODO Auto-generated method stub
		return false;
	}

}
