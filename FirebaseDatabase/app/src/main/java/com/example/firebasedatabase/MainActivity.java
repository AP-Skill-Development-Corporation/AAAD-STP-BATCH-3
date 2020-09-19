package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText name,roll,number;
    RecyclerView rv;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        number = findViewById(R.id.number);
        rv = findViewById(R.id.rv);
        reference = FirebaseDatabase.getInstance().getReference("Data");
        //To read the data from the firebase database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    MyModel model = dataSnapshot.getValue(MyModel.class);
                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void save(View view) {
        String sname = name.getText().toString();
        String sroll = roll.getText().toString();
        String snum = number.getText().toString();
        MyModel model = new MyModel(sname,sroll,snum);
       // String id = reference.push().getKey();
        //This is to write the data into the firebase database.
        reference.child(sroll).setValue(model);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}