package com.sooman_che.restaurant.interfaces;

import com.sooman_che.restaurant.domain.Restaurant;
import com.sooman_che.restaurant.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/{id}")
    public Restaurant detail(@PathVariable Long id) {
        return repository.findById(id);
    }
}
