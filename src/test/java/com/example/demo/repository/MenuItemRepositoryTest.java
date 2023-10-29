package com.example.demo.repository;

import com.example.demo.model.MenuItem;
import com.example.demo.model.Orderr;
import com.example.demo.model.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MenuItemRepositoryTest {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Test
    public void givenMenuItem_whenSave_thenReturnSavedMenuItem() {

        MenuItem menuItem = new MenuItem("Sandwich", 5.99, "desc", null, null);
        menuItemRepository.save(menuItem);

        MenuItem savedItem = menuItemRepository.save(menuItem);

        assertThat(savedItem.getName()).isEqualTo("Sandwich");
    }

    @Test
    public void givenSavedMenuItem_whenFindById_thenReturnMenuItem() {

        MenuItem givenMenu = new MenuItem("Sandwich", 5.99, "desc", null, null);
        menuItemRepository.save(givenMenu);

        MenuItem item = menuItemRepository.findById(givenMenu.getId()).get();

        assertThat(item.getPrice()).isEqualTo(5.99);
    }

}