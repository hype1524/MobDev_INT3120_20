package com.example.pro10_contentprovider;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {

    private static final int REQUEST_CONTACT_PERMISSION = 1001;
    ListView lv;
    ArrayList<ContactInfor> ds;
    ArrayAdapter<ContactInfor> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        addControls();
        showAllContact();
//        deleteContact();
        addContact();
    }
    public void showAllContact() {
        Uri uri = ContactsContract.Data.CONTENT_URI;

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        ds.clear();
        while (cursor.moveToNext()) {
            String col = ContactsContract.Data.RAW_CONTACT_ID;
            String columName = ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME;
            String columPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int trace = cursor.getColumnIndex(col);
            Log.d("Trace", "showAllContact: " + cursor.getString(trace));
            int pN = cursor.getColumnIndex(columName);
            int pP = cursor.getColumnIndex(columPhone);
            ContactInfor newContact = new ContactInfor(cursor.getString(pN), cursor.getString(pP));
            ds.add(newContact);
            ad.notifyDataSetChanged();
        }

    }
    public void addContact() {
        int rawContactId = 86; // Lấy rawContactId từ nguồn dữ liệu khác

        ArrayList<ContentProviderOperation> operations = new ArrayList<>();
        operations.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts._ID, rawContactId)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .build());

        ContentProviderOperation nameOperation = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValue(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, "Chao2")
                .build();
        operations.add(nameOperation);

        ContentProviderOperation phoneOperation = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValue(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, "012018387")
                .build();
        operations.add(phoneOperation);

        try {
            ContentProviderResult[] results = getContentResolver().applyBatch(ContactsContract.AUTHORITY, operations);
            if (results != null && results.length > 0) {
                ContentProviderResult result = results[0]; // Assuming you have only one update operation

                // Check the number of rows affected (should be 1 if the update was successful)
                int count = result.count;
                if (count == 1) {
                    Log.d("999", "addContact: ");
                } else {

                }
            }

        } catch (Exception e) {

        }
    }
    public void deleteContact() {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            int columnIdIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
            String contactId = cursor.getString(columnIdIndex);
            int columnIdIndex1 = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID);
            String contactId1 = cursor.getString(columnIdIndex1);
            Log.d("1", "showAllContact: " + contactId + " " + contactId1);
            String selection = ContactsContract.CommonDataKinds.Phone._ID + " = ? AND "
                    + ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?";
            String[] selectionArgs = new String[] {contactId1, contactId};

            int deletedRows = getContentResolver().delete(uri, selection, selectionArgs);
            Log.d("2", "showAllContact: " + deletedRows);
        }
    }
    public void addControls() {
        lv = findViewById(R.id.Contact);
        ds = new ArrayList<>();
        ad = new ArrayAdapter<>(Contact.this, android.R.layout.simple_list_item_1, ds);
        lv.setAdapter(ad);
    }
}