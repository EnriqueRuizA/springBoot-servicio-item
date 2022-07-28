package com.enrique.service.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.enrique.service.item.models.Item;
import com.enrique.service.item.models.Producto;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {

//		Obtenemos el path del controller que nos devuelve un array de productos
//		/springBoot-servicio-productos/src/main/java/com/enrique/service/controllers/ProductoRestController.java
		Producto[] productoArray = clienteRest.getForObject("http://localhost:8001/listar", Producto[].class);
		
//		Convertimos el Array en un List
		List<Producto> productoList = Arrays.asList(productoArray);
		
//		Convertimos los "productos" en "items"
//		debemos descomponer la lista en elementos con "stream" mapearlos a Item y construir un list de nuevo
		List<Item> productoItem = productoList.stream().map(p -> new Item(p ,1)).collect(Collectors.toList());
//		List<Item> productoItem = productoList.stream().map(p -> new Item(p ,1)).toList();
		
		return productoItem;
	}

	@Override
	public Item findById(Long id, int cantidad) {
//		para poder pasar parámetros a través de una URL necesitamos parametrizar con un map de tipo String
		Map<String, String> variableDelPath = new HashMap<String, String>();
		variableDelPath.put("id", id.toString());
		
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, variableDelPath);

		return new Item(producto, cantidad);
	}

}
