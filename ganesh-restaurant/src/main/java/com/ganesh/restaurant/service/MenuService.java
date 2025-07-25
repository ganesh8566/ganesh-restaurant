package com.ganesh.restaurant.service;

import com.ganesh.restaurant.model.MenuItem;
import com.ganesh.restaurant.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

	@Autowired
	private MenuItemRepository menuRepo;

	public List<MenuItem> getAllItems() {
		return menuRepo.findAll();
	}

	public MenuItem addItem(MenuItem item) {
		return menuRepo.save(item);
	}

	public void deleteItem(Long id) {
		menuRepo.deleteById(id);
	}
}