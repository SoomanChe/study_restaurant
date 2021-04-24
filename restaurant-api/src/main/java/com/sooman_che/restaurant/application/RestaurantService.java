package com.sooman_che.restaurant.application;

import com.sooman_che.restaurant.domain.MenuItem;
import com.sooman_che.restaurant.domain.MenuItemRepository;
import com.sooman_che.restaurant.domain.Restaurant;
import com.sooman_che.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant saved = restaurantRepository.save(restaurant);
        return saved;
    }
}
