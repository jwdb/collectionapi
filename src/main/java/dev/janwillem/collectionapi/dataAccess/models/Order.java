package dev.janwillem.collectionapi.dataAccess.models;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private UUID userID;
    private int status;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Instant createDate;

    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Order(UUID userID, int status) {
        this.userID = userID;
        this.status = status;
    }

    public Order() {

    }
}
