package com.sooman_che.restaurant.domain;

public class Restaurant {

    private final String name;
    private String address;

    public Restaurant(final String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Object getName() {
        return name;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public String getAddress() {
        return address;
    }
}
