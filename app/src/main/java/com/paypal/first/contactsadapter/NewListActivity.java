package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        List<Person> listPerson = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setFirstName("first " + i);
            person.setLastName("last " + i);
            person.setAge(i + 1);
            listPerson.add(person);
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        NewListAdapter adapter = new NewListAdapter(this, R.layout.newlistlayout, listPerson);
        listView.setAdapter(adapter);

    }

}
