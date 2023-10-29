package com.example.demo.controller.impl;

import com.example.demo.controller.interfaces.IMenuItemController;
import com.example.demo.model.MenuItem;
import com.example.demo.model.Staff;
import com.example.demo.service.interfaces.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController implements IMenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    //  ****************************************************  POST  ****************************************************
    @PostMapping("/")
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.addMenuItem(menuItem);
    }

    //  ****************************************************  GET  ****************************************************
    @GetMapping("/")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable("id") Long id) {
        return menuItemService.getMenuItemById(id);
    }

    //  ****************************************************  PUT  ****************************************************
    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable("id") Long id, @RequestBody MenuItem menuItem) {
        return menuItemService.updateMenuItemById(id, menuItem);
    }

    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable("id") Long id) {
        return menuItemService.deleteMenuItem(id);
    }


}
