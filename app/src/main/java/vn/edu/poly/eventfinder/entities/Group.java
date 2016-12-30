package vn.edu.poly.eventfinder.entities;

import java.util.List;

public class Group {
    private int id;
    private String name;
    private int eventDate;
    private int createdDate;
    private User byUser;
    private List<User> addedUser;

    public Group() {
    }

    public Group(int id, String name, int eventDate, int createdDate, User byUser, List<User> addedUser) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.createdDate = createdDate;
        this.byUser = byUser;
        this.addedUser = addedUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventDate() {
        return eventDate;
    }

    public void setEventDate(int eventDate) {
        this.eventDate = eventDate;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public User getByUser() {
        return byUser;
    }

    public void setByUser(User byUser) {
        this.byUser = byUser;
    }

    public List<User> getAddedUser() {
        return addedUser;
    }

    public void setAddedUser(List<User> addedUser) {
        this.addedUser = addedUser;
    }
}
