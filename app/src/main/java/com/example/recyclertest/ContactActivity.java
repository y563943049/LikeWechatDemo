package com.example.recyclertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private List<Contact> mContacts = new ArrayList<>();

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.contact_bar);
        setSupportActionBar(toolbar);
        initContacts();
        mRecyclerView = (RecyclerView) findViewById(R.id.contact_recycle_view);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        ContactAdapter adapter = new ContactAdapter(this,mContacts);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);

    }

    private void initContacts() {
        Contact contact = new Contact();
        contact.setImageID(R.drawable.leimu);
        contact.setMessage("在吗？亲爱的");
        contact.setName("阿玥");
        contact.setTime("22:16");
        mContacts.add(contact);
        Contact contact1 = new Contact();
        contact1.setImageID(R.drawable.leimur);
        contact1.setTime("15:32");
        contact1.setName("雷姆");
        contact1.setMessage("起床啦。主人");
        mContacts.add(contact1);
    }
}
