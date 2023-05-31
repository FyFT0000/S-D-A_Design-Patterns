package com.example.sharingapp;

import android.content.Context;
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
        contactList.setContacts(contact_list);
    }
    public ArrayList<Contact> getContacts(){
        return contactList.getContacts();
    }
    public ArrayList<String> getAllUsernames(){
        return contactList.getAllUsernames();
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
        return contactList.getContact(index);
    }
    public int getSize() {
        return contactList.getSize();
    }
    public int getIndex(Contact contact) {
        return contactList.getIndex(contact);
    }
    public boolean hasContact(Contact contact) {
        return contactList.hasContact(contact);
    }
    public Contact getContactByUsername(String username) {
        return contactList.getContactByUsername(username);
    }
    public void loadContacts(Context context) {
        contactList.loadContacts(context);
    }
    public boolean saveContacts(Context context) {
        return contactList.saveContacts(context);
    }
    public boolean isUsernameAvailable(String username) {
        return contactList.isUsernameAvailable(username);
    }
    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }
    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }
}
