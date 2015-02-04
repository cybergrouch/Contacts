package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GetPhoneNumber extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getphone);
        Button but = (Button) findViewById(R.id.grpbut);
        but.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText et = (EditText) findViewById(R.id.num);
                String phoneNumber = et.getText().toString();
                Intent intent = new Intent(GetPhoneNumber.this, ContactListActivity.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
            }
        });

    }


}
