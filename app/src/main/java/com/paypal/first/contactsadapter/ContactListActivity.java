package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactListActivity extends Activity {

    public static final String TAG = "APPLOGS::Contacts::ContactListActivity: %s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView listView = (ListView) findViewById(R.id.list);

        List<ContactBean> list = new ArrayList<>();
        list.clear();
        list.addAll(doGetListOfContactBean());

        ContactAdapter objAdapter = new ContactAdapter(ContactListActivity.this, R.layout.alluser_row, list);
        listView.setAdapter(objAdapter);

        if (null != list && list.size() != 0) {
            Collections.sort(list, new Comparator<ContactBean>() {
                @Override
                public int compare(ContactBean lhs, ContactBean rhs) {
                    return lhs.getName().compareTo(rhs.getName());
                }
            });

            AlertDialog alert = new AlertDialog.Builder(ContactListActivity.this).create();
            alert.setTitle("");

            alert.setMessage(list.size() + " Contact Found!!!");

            alert.setButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.show();

        } else {
            showToast("No Contact Found!!!");
        }
    }

    private List<ContactBean> doGetListOfContactBean() {
        List<ContactBean> contacts = new ArrayList<ContactBean>();
        Cursor phones = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
                null, null);
        while (phones.moveToNext()) {

            String name = phones
                    .getString(phones
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            String contactNumber = phones
                    .getString(phones
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            ContactBean objContact = new ContactBean();
            objContact.setName(name);
            objContact.setPhoneNo(contactNumber);
            contacts.add(objContact);

        }
        phones.close();

        return contacts;
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
