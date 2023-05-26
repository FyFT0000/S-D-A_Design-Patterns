package com.example.sharingapp;
import android.content.Context;
/**
 * Command to delete an item
 */
public class DeleteContactCommand extends Command{
    ContactList contactList;
    Contact contact;
    Context context;

    public DeleteContactCommand(ContactList contactList, Contact contact, Context context) {
        this.contactList = contactList;
        this.contact = contact;
        this.context = context;
    }

    public void execute() {
        contactList.deleteContact(contact);
        setIsExecuted(contactList.saveContacts(context));
    }
}
