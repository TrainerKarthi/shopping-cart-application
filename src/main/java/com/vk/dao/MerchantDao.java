package com.vk.dao;

import java.util.List;

import com.vk.dto.Merchant;

public interface MerchantDao {
public Merchant saveMerchant(Merchant p);
	
	public Merchant findMerchantById(int id);
	
	public List<Merchant> findAllMerchants();
	
	public boolean updateMerchantById(int id, Merchant p);

}
