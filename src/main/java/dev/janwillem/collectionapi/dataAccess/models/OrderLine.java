package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class OrderLine {
    @Id
    private UUID Id;
    private UUID OrderID;
    private UUID ProductID;
    private int Qty;
    private double ProductPrice;

    public UUID getId() {
        return Id;
    }

    public UUID getOrderID() {
        return OrderID;
    }

    public void setOrderID(UUID orderID) {
        OrderID = orderID;
    }

    public UUID getProductID() {
        return ProductID;
    }

    public void setProductID(UUID productID) {
        ProductID = productID;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public OrderLine(UUID orderID, UUID productID, int qty, double productPrice) {
        OrderID = orderID;
        ProductID = productID;
        Qty = qty;
        ProductPrice = productPrice;
    }

    public OrderLine()
    {

    }
}
