package dev.janwillem.collectionapi.dataAccess.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", insertable = false, updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID userID;
    private int orderStatus;
    @Basic(optional = false)
    @Column(name = "CreateDate", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Order(UUID userID, int status) {
        this.userID = userID;
        this.orderStatus = status;
    }

    public Order() {

    }
}
