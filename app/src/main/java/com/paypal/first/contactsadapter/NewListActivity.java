package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NewListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        final List<Person> listPerson = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setFirstName("first " + i);
            person.setLastName("last " + i);
            person.setAge(i + 1);
            listPerson.add(person);
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        final NewListAdapter adapter = new NewListAdapter(this, R.layout.newlistlayout, listPerson);
        listView.setAdapter(adapter);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Person person = new Person();
                long timestamp = System.currentTimeMillis();
                person.setFirstName("firstname_timer-" + timestamp);
                person.setLastName("lastname_timer-" + timestamp);
                person.setAge((int) timestamp % 50);
                listPerson.add(person);
                runOnUiThread(new Runnable() {
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }, 5000, 5000);

    }


}
