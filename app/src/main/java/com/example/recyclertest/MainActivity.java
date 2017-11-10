 package com.example.recyclertest;

 import android.content.Intent;
 import android.os.Bundle;
 import android.support.v7.app.ActionBar;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.support.v7.widget.Toolbar;
 import android.text.TextUtils;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;

 import java.util.ArrayList;
 import java.util.List;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{

     private RecyclerView mRecyclerView;

     private List<Msg> mMsgs = new ArrayList<>();

     private MyAdapter adapter;

     private Button send;

     private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        initMsgs();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.message);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.contact);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        adapter = new MyAdapter(MainActivity.this,mMsgs);
        mRecyclerView.setAdapter(adapter);
    }

     @Override
     public void onClick(View view) {
         switch (view.getId()){
             case R.id.send:
                 String message = editText.getText().toString();
                 if (!TextUtils.isEmpty(message)){
                 mMsgs.add(new Msg(message,Msg.TYPE_SEND));
                 adapter.notifyDataSetChanged();
                 editText.setText("");}
                 break;
             default:
                 break;
         }
     }

     private void initMsgs() {
         Msg msg1 = new Msg("hello,cyuan",Msg.TYPE_RECEIVED);
         mMsgs.add(msg1);
         Msg msg2 = new Msg("hi,leimu",Msg.TYPE_SEND);
         mMsgs.add(msg2);
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.contact,menu);
         return true;
     }

     @Override
         public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()) {
             case R.id.contact:
                 Intent intent = new Intent(MainActivity.this,PersoInfoActivity.class);
                 startActivity(intent);
                 break;
             case android.R.id.home:
                 Intent intent1 = new Intent(MainActivity.this,ContactActivity.class);
                 startActivity(intent1);
                 break;
             default:
                 break;
         }
         return true;
     }

 }
