package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {
    @Id
    private UUID Id;
    private String Name;
    private double Price;
    private int Supply;
    private UUID GroupID;

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getSupply() {
        return Supply;
    }

    public void setSupply(int supply) {
        Supply = supply;
    }

    public UUID getGroupID() {
        return GroupID;
    }

    public void setGroupID(UUID groupID) {
        GroupID = groupID;
    }

    public Product() {

    }

    public Product(String name, double price, int supply, UUID groupID) {
        Name = name;
        Price = price;
        Supply = supply;
        GroupID = groupID;
    }
}
