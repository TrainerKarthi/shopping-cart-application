package com.vk.dao;

import java.util.List;

import com.vk.dto.Item;

public interface ItemDao {
public Item saveItem(Item p);
	
	public Item findItemById(int id);
	
	public List<Item> findAllItems();
	
	public boolean updateItemById(int id, Item p);

}
