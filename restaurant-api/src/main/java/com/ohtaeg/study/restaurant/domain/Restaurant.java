package com.ohtaeg.study.restaurant.domain;

public class Restaurant {

    private final long id;
    private final String name;
    private final String address;

    public Restaurant(final long id, final String name, final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getInformation() {
        return name + " / " + address;
    }
}
