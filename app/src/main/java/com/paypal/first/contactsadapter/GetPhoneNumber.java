package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GetPhoneNumber extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getphone);

        Button oldContactListButton = (Button) findViewById(R.id.contactButton);
        oldContactListButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetPhoneNumber.this, ContactListActivity.class);
                startActivity(intent);
            }
        });

        Button newContactListButton = (Button) findViewById(R.id.newContractsListButton);
        newContactListButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetPhoneNumber.this, NewListActivity.class);
                startActivity(intent);
            }
        });

    }


}
