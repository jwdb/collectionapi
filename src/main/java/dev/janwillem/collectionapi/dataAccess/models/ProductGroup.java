package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ProductGroup {
    @Id
    private UUID Id;
    private String Name;
    private UUID ParentID;

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UUID getParentID() {
        return ParentID;
    }

    public void setParentID(UUID parentID) {
        ParentID = parentID;
    }

    public ProductGroup() {

    }

    public ProductGroup(String name, UUID parentID) {
        Name = name;
        ParentID = parentID;
    }

    public ProductGroup(String name) {
        Name = name;
    }
}
