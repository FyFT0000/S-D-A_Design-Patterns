package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * ItemListController is responsible for all communication between views and ItemList object
 */
public class ContactListController {

    private Contact contact;
    private ContactList contactList;

    public ContactListController(ContactList contactList) {
        this.contactList = contactList;
    }

    public void setContacts(ArrayList<Contact> contact_list) {
        this.setContacts(contact_list);
    }
    public ArrayList<Contact> getContacts(){
        return this.getContacts();
    }
    public ArrayList<String> getAllUsernames(){
        return this.getAllUsernames();
    }
    public boolean addContact(Contact contact, Context context) {
        AddContactCommand add_contact_command = new AddContactCommand(contactList, contact, context);
        add_contact_command.execute();
        return add_contact_command.isExecuted();
    }
    public boolean deleteContact(Contact contact, Context context) {
        DeleteContactCommand delete_contact_command = new DeleteContactCommand(contactList, contact, context);
        delete_contact_command.execute();
        return delete_contact_command.isExecuted();
    }
    public boolean editContact(Contact oldContact, Contact newContact, Context context) {
        EditContactCommand editContactCommand = new EditContactCommand(contactList, oldContact, newContact, context);
        editContactCommand.execute();
        return editContactCommand.isExecuted();
    }
    public Contact getContact(int index) {
        return this.getContact(index);
    }
    public int getSize() {
        return this.getSize();
    }
    public int getIndex(Contact contact) {
        return this.getIndex(contact);
    }
    public boolean hasContact(Contact contact) {
        return this.hasContact(contact);
    }
    public Contact getContactByUsername(String username) {
        return this.getContactByUsername(username);
    }
    public void loadContacts(Context context) {
        this.loadContacts(context);
    }
    public boolean saveContacts(Context context) {
        return this.saveContacts(context);
    }
    public boolean isUsernameAvailable(String username) {
        return this.isUsernameAvailable(username);
    }
    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }
    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }
}
