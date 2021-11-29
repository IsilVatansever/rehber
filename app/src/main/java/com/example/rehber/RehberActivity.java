package com.example.rehber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RehberActivity extends AppCompatActivity {


    public static final int REQUEST_READ_CONTACTS = 1;
    Cursor cursor;
    ListView contacts;
    TextView contactName;
    TextView contactPhone;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber);
        contacts = findViewById(R.id.list_contacts);
        getContacts();
    }
    public  void getContacts(){


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);
            startManagingCursor(cursor);
            String[] data = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone._ID};
            int[] to = {android.R.id.text1, android.R.id.text2};
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, data, to);
            contacts.setAdapter(adapter);
            contacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        } else
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_READ_CONTACTS);

    }
}