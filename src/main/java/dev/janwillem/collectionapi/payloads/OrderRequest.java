package dev.janwillem.collectionapi.payloads;

import java.util.ArrayList;
import java.util.UUID;

public class OrderRequest {
    private UUID id;
    private String name;
    private String street;
    private String ZIP;
    private String city;

    private ArrayList<OrderProductRequest> products;

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

    public ArrayList<OrderProductRequest> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<OrderProductRequest> products) {
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
