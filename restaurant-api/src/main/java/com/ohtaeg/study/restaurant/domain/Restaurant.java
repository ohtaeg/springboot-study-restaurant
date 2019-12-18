package com.ohtaeg.study.restaurant.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final long id;
    private final String name;
    private final String address;
    private List<MenuItem> menuItems = new ArrayList<>();

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

    public void addMenuItem(final MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItem(final List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            addMenuItem(menuItem);
        }
    }
}
