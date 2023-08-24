package com.vk.service;

import java.util.List;

import com.vk.dto.Item;

public interface ItemService {
public Item saveItem(Item p);
	
	public Item findItemById(int id);
	
	public List<Item> findAllItems();
	
	public boolean updateItemById(int id, Item p);

}
