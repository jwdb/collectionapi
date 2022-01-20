package dev.janwillem.collectionapi.payloads;

import java.util.ArrayList;

public class NewOrderRequest {
    private String name;
    private String street;
    private String ZIP;
    private String city;

    private ArrayList<NewOrderProductRequest> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<NewOrderProductRequest> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<NewOrderProductRequest> products) {
        this.products = products;
    }
}
