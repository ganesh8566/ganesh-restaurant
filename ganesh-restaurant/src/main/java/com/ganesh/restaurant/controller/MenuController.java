package com.ganesh.restaurant.controller;

import com.ganesh.restaurant.model.MenuItem;
import com.ganesh.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/all")
	public List<MenuItem> getAllItems() {
		return menuService.getAllItems();
	}

	@PostMapping("/add")
	public MenuItem addItem(@RequestBody MenuItem item) {
		return menuService.addItem(item);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable Long id) {
		menuService.deleteItem(id);
		return "Menu item deleted";
	}
}