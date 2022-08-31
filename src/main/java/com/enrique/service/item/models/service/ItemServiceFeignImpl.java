package com.enrique.service.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.enrique.service.item.clientes.ProductoClienteRest;
import com.enrique.service.item.models.Item;
import com.enrique.service.item.models.Producto;

@Service("serviceFeign")
//@Primary
public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return productListToItemList(clienteFeign.listar());
	}

	@Override
	public Item findById(Long id, int cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	public List<Item> productListToItemList(List<Producto> productoList) {
		return productoList.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

}
