package com.example.sharingapp;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/**
 * Add a new contact
 */
public class AddContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
    private ContactListController contactListController = new ContactListController(contact_list);
    private Context context;
    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contactListController.loadContacts(context);
    }

    public void saveContact(View view) {

        if(!validateInput()) {
            return;
        }

        Contact contact = new Contact(username.getText().toString(), email.getText().toString(), null);

        // Add contact
        boolean success = contactListController.addContact(contact, context);
        if (!success) {
            return;
        }

        // End AddContactActivity
        finish();
    }

    public boolean validateInput() {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return false;
        }

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return false;
        }

        if (!email_str.contains("@")){
            email.setError("Must be an email address!");
            return false;
        }

        if (!contactListController.isUsernameAvailable(username_str)){
            username.setError("Username already taken!");
            return false;
        }

        return true;
    }
}