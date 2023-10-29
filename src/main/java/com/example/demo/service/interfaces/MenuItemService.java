package com.example.demo.service.interfaces;

import java.util.List;


import com.example.demo.model.MenuItem;


public interface MenuItemService {
    List<MenuItem> getAllMenuItems();

    MenuItem getMenuItemById(Long id);

    MenuItem addMenuItem(MenuItem menuItem);

    MenuItem updateMenuItemById(Long id, MenuItem menuItem);

    String deleteMenuItem(Long id);
}

