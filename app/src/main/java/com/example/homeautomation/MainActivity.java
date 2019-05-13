package com.example.homeautomation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRoom;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Room> dataRoom = new ArrayList<>();

    Firebase firebase;
    DatabaseReference databaseReference;

    public static final String Firebase_Server_URL = "https://homeautomation-a5039.firebaseio.com/";
    public static final String Database_Path = "homeautomation-a5039";

    

    public MainActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        firebase = new Firebase(Firebase_Server_URL);

        rvRoom = (RecyclerView) findViewById(R.id.rv_main);
        rvRoom.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvRoom.setLayoutManager(layoutManager);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String name = dataSnapshot.toString();
                    int status = dataSnapshot.child("LAMPU_TERAS").getValue(Integer.class);
                    Room room = dataSnapshot.getValue(Room.class);
                    dataRoom.add(room);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getParent(), "Not Found", Toast.LENGTH_SHORT).show();
            }
        };

        adapter = new RoomAdapter(dataRoom,this);
        rvRoom.setAdapter(adapter);
//        adapter = new RoomAdapter(dataRoom);
//        rvRoom.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()){
            case R.id.item1:
                intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                intent = new Intent(MainActivity.this, GantiPassActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
