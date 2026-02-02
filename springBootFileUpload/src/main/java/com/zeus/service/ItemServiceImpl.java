package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.domain.Item;
import com.zeus.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public int create(Item item) throws Exception {
		return itemMapper.create(item);
	}

	@Override
	public Item read(Item i) throws Exception {
		Item item = itemMapper.read(i);
		return item;
	}

	@Override
	public int update(Item item) throws Exception {
		int count = itemMapper.update(item);
		return count;
		
	}

	@Override
	public int delete(Item item) throws Exception {
		int count = itemMapper.delete(item);
		return count;
	}

	@Override
	public List<Item> list() throws Exception {
		List<Item> itemList = itemMapper.list();
		return itemList;
	}

	@Override
	public String getPicture(Item item) throws Exception {
		String url = itemMapper.getPicture(item);
		return url;
	}

}
