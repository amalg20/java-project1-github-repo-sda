package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.example.demo.model.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.service.interfaces.MenuItemService;


@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepo.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepo.findById(id).orElse(null);
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepo.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItemById(Long id, MenuItem menuItem) {
        menuItemRepo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        menuItem.setId(id);

        return menuItemRepo.save(menuItem);
    }

    @Override
    public String deleteMenuItem(Long id) {

        if (menuItemRepo.findById(id).isPresent()) {
            menuItemRepo.deleteById(id);
            return "MenuItem deleted successfully";
        }
        return "No such MenuItem in the database";
    }

}

