package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText BusinessnumberField, NameField, PrimaryBusinessField, AddressField, ProvinceterritoryField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        BusinessnumberField = (EditText) findViewById(R.id.businessnumberIn);
        NameField = (EditText) findViewById(R.id.nameIn);
        PrimaryBusinessField = (EditText) findViewById(R.id.primarybusinessIn);
        AddressField = (EditText) findViewById(R.id.addressIn);
        ProvinceterritoryField = (EditText) findViewById(R.id.provinceterritoryIn);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String Businessnumber = BusinessnumberField.getText().toString();
        String Name = NameField.getText().toString();
        String PrimaryBusiness = PrimaryBusinessField.getText().toString();
        String Address = AddressField.getText().toString();
        String Provinceterritory = ProvinceterritoryField.getText().toString();

        Contact person = new Contact(personID, Businessnumber, Name, PrimaryBusiness, Address, Provinceterritory);
        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
