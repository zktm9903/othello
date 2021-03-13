package com.example.othello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class lobi extends AppCompatActivity {

    EditText make_room_id;
    EditText room_id;
    Button make_room;
    Button Entrance;
    lobiInfo LobiInfo;
    String myEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobi);

        make_room_id = (EditText) findViewById(R.id.make_room_id);
        room_id = (EditText) findViewById(R.id.room_id);
        make_room = (Button) findViewById(R.id.make_room);
        Entrance = (Button) findViewById(R.id.Entrance);

        Intent intent = getIntent();
        myEmail = intent.getStringExtra("email");

        LobiInfo = new lobiInfo();

        make_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String room_id_text = make_room_id.getText().toString();

                if(room_id_text.isEmpty())
                    return;
                LobiInfo.create_room(room_id_text, myEmail, "o");
            }
        });
    }
}