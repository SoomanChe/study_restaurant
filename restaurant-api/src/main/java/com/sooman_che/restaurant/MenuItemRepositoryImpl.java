package com.sooman_che.restaurant;

import com.sooman_che.restaurant.domain.MenuItem;
import com.sooman_che.restaurant.domain.MenuItemRepository;

import java.util.ArrayList;
import java.util.List;

public class MenuItemRepositoryImpl implements MenuItemRepository {

    private final List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRepositoryImpl() {
        menuItems.add(new MenuItem("kimchi"));
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Long id) {

        return menuItems;
    }
}
