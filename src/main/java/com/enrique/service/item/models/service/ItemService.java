package com.enrique.service.item.models.service;

import java.util.List;

import com.enrique.service.item.models.Item;

public interface ItemService {
	public List<Item> findAll();
	public Item	findById(Long id, int cantidad);
}
