package dev.janwillem.collectionapi.payloads;

import java.util.UUID;

public class NewOrderProductRequest {
    private UUID productID;
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
}
