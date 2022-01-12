package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;
@Entity
public class User {
    @Id
    private UUID id;
    private String Name;
    private String Password;
    private String Username;
    private boolean Admin;
    private Instant CreateDate;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    public Instant getCreateDate() {
        return CreateDate;
    }

    public User(String name, String username, String password, boolean isAdmin) {
        Name = name;
        Password = password;
        Username = username;
        Admin = isAdmin;
    }

    public User(String name) {
        Name = name;
    }

    public User() {

    }
}
