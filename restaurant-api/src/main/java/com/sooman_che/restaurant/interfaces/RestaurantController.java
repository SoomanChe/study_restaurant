package com.sooman_che.restaurant.interfaces;

import com.sooman_che.restaurant.application.RestaurantService;
import com.sooman_che.restaurant.domain.MenuItem;
import com.sooman_che.restaurant.domain.MenuItemRepository;
import com.sooman_che.restaurant.domain.Restaurant;
import com.sooman_che.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("")
    public List<Restaurant> list() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant detail(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }
}
