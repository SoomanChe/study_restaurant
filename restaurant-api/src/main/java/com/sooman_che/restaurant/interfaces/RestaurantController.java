package com.sooman_che.restaurant.interfaces;

import com.sooman_che.restaurant.application.RestaurantService;
import com.sooman_che.restaurant.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
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

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Restaurant request) throws URISyntaxException {
        Restaurant restaurant = new Restaurant(1234L, request.getName(), request.getAddress());
        restaurantService.addRestaurant(restaurant);
        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }
}
