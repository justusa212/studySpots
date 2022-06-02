package com.example.studyspots.model;

public class Spot {
    private long id;
    private String location;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Spot(long id, String location, String description) {
        this.id = id;
        this.location = location;
        this.description = description;
    }

    public Spot() {
    }
}