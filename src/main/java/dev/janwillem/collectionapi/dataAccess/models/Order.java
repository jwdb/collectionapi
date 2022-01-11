package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Order {

    @Id
    private UUID Id;
    private UUID UserID;
    private int Status;
    private Instant CreateDate;

    public UUID getId() {
        return Id;
    }

    public UUID getUserID() {
        return UserID;
    }

    public void setUserID(UUID userID) {
        UserID = userID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Instant getCreateDate() {
        return CreateDate;
    }

    public Order(UUID userID, int status) {
        UserID = userID;
        Status = status;
    }

    public Order() {

    }
}
