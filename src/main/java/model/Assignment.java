package model;

import java.io.Serializable;

public class Assignment implements Serializable {

    private String id;
    private String description;

    public Assignment(String id, String description){
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
