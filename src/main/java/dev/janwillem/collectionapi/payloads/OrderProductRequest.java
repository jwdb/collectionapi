package dev.janwillem.collectionapi.payloads;

import java.util.UUID;

public class OrderProductRequest {
    private UUID productID;
    private String productName;
    private int qty;

    public UUID getProductID() {
        return productID;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
