package com.example.sharingapp;
import android.content.Context;
/**
 * Command to edit a pre-existing Contact
 */
public class EditContactCommand extends Command {
    ContactList contactList;
    Contact newContact;
    Contact oldContact;
    Context context;

    public EditContactCommand(ContactList contactList, Contact oldContact, Contact newContact, Context context) {
        this.contactList = contactList;
        this.newContact = newContact;
        this.oldContact = oldContact;
        this.context = context;
    }

    public void execute(){
        contactList.deleteContact(oldContact);
        contactList.addContact(newContact);
        setIsExecuted(contactList.saveContacts(context));
    }
}
