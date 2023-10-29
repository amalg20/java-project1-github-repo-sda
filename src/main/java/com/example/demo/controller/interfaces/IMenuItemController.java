package com.example.demo.controller.interfaces;

import com.example.demo.model.MenuItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IMenuItemController {

    public MenuItem updateMenuItem(Long id, MenuItem menuItem);

    public MenuItem saveMenuItem(MenuItem menuItem);

    public List<MenuItem> getAllMenuItems();

    public MenuItem getMenuItemById(Long id);

    public String deleteMenuItem(Long id);
}
