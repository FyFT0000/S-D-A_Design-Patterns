package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Editing a pre-existing contact consists of deleting the old contact and adding a new contact with the old
 * contact's id.
 * Note: You will not be able contacts which are "active" borrowers
 */
public class EditContactActivity extends AppCompatActivity implements Observer {

    private ContactList contact_list = new ContactList();
    private ContactListController contactListController = new ContactListController(contact_list);
    private Contact contact;
    private ContactController contactController;
    private EditText email;
    private EditText username;
    private Context context;

    private boolean on_create_update = true;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);

        context = getApplicationContext();
        contactListController.addObserver(this);
        contactListController.loadContacts(context);
        on_create_update = false;
    }

    public void saveContact(View view) {

        String email_str = email.getText().toString();
        String username_str = username.getText().toString();


        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        if (!email_str.contains("@")){
            email.setError("Must be an email address!");
            return;
        }

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        // Check that username is unique AND username is changed (Note: if username was not changed
        // then this should be fine, because it was already unique.)
        if (!contactListController.isUsernameAvailable(username_str) && !(contactController.getUsername().equals(username_str))) {
            username.setError("Username already taken!");
            return;
        }

        String id = contact.getId(); // Reuse the contact id
        Contact updated_contact = new Contact(username_str, email_str, id);

        // Edit Contact: replace contact with updated contact
        boolean success = contactListController.editContact(contact, updated_contact, context);
        if(!success) {
            return;
        }

        // End EditContactActivity
        finish();
    }

    public void deleteContact(View view) {

        // Delete contact
        boolean success = contactListController.deleteContact(contact, context);
        if(!success) {
            return;
        }

        // End EditContactActivity
        finish();
    }

    /**
     * Called when the activity is destroyed, thus we remove this activity as a listener
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        contactListController.removeObserver(this);
    }

    /**
     * Only need to update the view from the onCreate method
     */
    @Override
    public void update() {
        if (on_create_update){
            contact = contactListController.getContact(pos);
            contactController = new ContactController(contact);

            username = (EditText) findViewById(R.id.username);
            email = (EditText) findViewById(R.id.email);

            // Update the view
            email.setText(contactController.getEmail());
            username.setText(contactController.getUsername());

        }
    }
}