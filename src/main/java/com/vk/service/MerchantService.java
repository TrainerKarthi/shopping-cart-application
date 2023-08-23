package com.vk.service;

import java.util.List;

import com.vk.dto.Merchant;

public interface MerchantService {
public Merchant saveMerchant(Merchant p);
	
	public Merchant findMerchantById(int id);
	
	public List<Merchant> findAllMerchants();
	
	public boolean updateMerchantById(int id, Merchant p);

}
