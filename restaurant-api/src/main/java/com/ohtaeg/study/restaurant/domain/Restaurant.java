package com.ohtaeg.study.restaurant.domain;

public class Restaurant {

    private final String name;
    private final String address;

    public Restaurant(final String name, final String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getInformation() {
        return name + " in " + address;
    }
}
