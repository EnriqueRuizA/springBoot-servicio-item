package com.enrique.service.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.service.item.models.Item;
import com.enrique.service.item.models.service.ItemService;

@RestController
public class ItemRestController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable int cantidad) {
		return itemService.findById(id, cantidad);
	}

}
