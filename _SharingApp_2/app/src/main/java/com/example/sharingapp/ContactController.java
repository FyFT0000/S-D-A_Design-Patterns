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
        contact.setId();
    }
    public String getId() {
        return contact.getId();
    }
    public void updateId(String id) {
        contact.updateId(id);
    }
    public void setUsername(String username) {
        contact.setUsername(username);
    }
    public String getUsername() {
        return contact.getUsername();
    }
    public void setEmail(String email) {
        contact.setEmail(email);
    }
    public String getEmail() {
        return contact.getEmail();
    }
    public Contact getContact() {
        return contact;
    }
    public void addObserver(Observer observer) {
        contact.addObserver(observer);
    }
    public void removeObserver(Observer observer) {
        contact.removeObserver(observer);
    }
}
