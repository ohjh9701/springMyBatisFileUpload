package com.zeus.service;

import java.util.List;

import com.zeus.domain.Item;

public interface ItemService {
	public void create(Item item) throws Exception;
	public Item read(Item item) throws Exception;
	public void update(Item item) throws Exception;
	public void delete(Item item) throws Exception;
	public List<Item> list() throws Exception;
	public String getPicture(Item item) throws Exception;
}
