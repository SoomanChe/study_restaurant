package com.sooman_che.restaurant.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Restaurant {

    private Long id;
    private String name;
    private String address;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(final Long id, final String name, final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems.addAll(menuItems);
    }

    public void setId(long id) {
        this.id = id;
    }
}
