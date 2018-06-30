package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText BusinessnumberField, NameField, PrimaryBusinessField, AddressField, ProvinceterritoryField;
    Contact receivedPersonInfo;
    private Button updateButton, deleteButton;
    private DatabaseReference data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        BusinessnumberField = (EditText) findViewById(R.id.businessnumberIn);
        NameField = (EditText) findViewById(R.id.nameIn);
        PrimaryBusinessField = (EditText) findViewById(R.id.primarybusinessIn);
        AddressField = (EditText) findViewById(R.id.addressIn);
        ProvinceterritoryField = (EditText) findViewById(R.id.provinceterritoryIn);

        if(receivedPersonInfo != null){
            BusinessnumberField.setText(receivedPersonInfo.businessNumber);
            NameField.setText(receivedPersonInfo.name);
            PrimaryBusinessField.setText(receivedPersonInfo.primBusiness);
            AddressField.setText(receivedPersonInfo.address);
            ProvinceterritoryField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        String personID = receivedPersonInfo.uid;
        String Businessnumber = BusinessnumberField.getText().toString();
        String Name = NameField.getText().toString();
        String PrimaryBusiness = PrimaryBusinessField.getText().toString();
        String Address = AddressField.getText().toString();
        String Provinceterritory = ProvinceterritoryField.getText().toString();

        data = FirebaseDatabase.getInstance().getReference();
        data.child("contacts").child(personID).child("Address").setValue(Address);
        data.child("contacts").child(personID).child("Businessnumber").setValue(Businessnumber);
        data.child("contacts").child(personID).child("Name").setValue(Name);
        data.child("contacts").child(personID).child("Primarybusiness").setValue(PrimaryBusiness);
        data.child("contacts").child(personID).child("Proviceterritory").setValue(Provinceterritory);

    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionalit\
        String personID = receivedPersonInfo.uid;

        data = FirebaseDatabase.getInstance().getReference();
        data.child("contacts").child(personID).removeValue();
        finish();
    }
}
