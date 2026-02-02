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
	public void create(Item item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item read(Item item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Item item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPicture(Item item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
