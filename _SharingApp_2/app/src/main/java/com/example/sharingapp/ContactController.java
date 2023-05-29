package com.example.sharingapp;

/**
 * ContactController is responsible for all communication between views and Contact object
 */
public class ContactController {

    private Contact contact;

    public ContactController (Contact contact) {
        this.contact = contact;
    }

    public void setId() {
        this.setId();
    }
    public String getId() {
        return this.getId();
    }
    public void updateId(String id) {
        this.updateId(id);
    }
    public void setUsername(String username) {
        this.setUsername(username);
    }
    public String getUsername() {
        return this.getUsername();
    }
    public void setEmail(String email) {
        this.setEmail(email);
    }
    public String getEmail() {
        return this.getEmail();
    }
    public Contact getContact() {
        return this.contact;
    }
    public void addObserver(Observer observer) {
        this.contact.addObserver(observer);
    }
    public void removeObserver(Observer observer) {
        this.contact.removeObserver(observer);
    }
}
