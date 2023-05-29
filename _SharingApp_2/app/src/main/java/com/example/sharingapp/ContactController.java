package com.example.sharingapp;

import java.util.UUID;

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

}
