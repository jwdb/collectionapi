package dev.janwillem.collectionapi.dataAccess.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String password;
    private String username;
    private boolean admin;
    @Basic(optional = false)
    @Column(name = "CreateDate", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public User(String name, String username, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.username = username;
        admin = isAdmin;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {

    }
}
