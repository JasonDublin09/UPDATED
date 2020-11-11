package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Levels_Animals extends AppCompatActivity {

    Button level1, level2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        level1 = findViewById(R.id.btnLevel1);
        level2 = findViewById(R.id.btnLevel2);

        level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(Levels_Animals.this,Animals_Level1.class));
            }
        });
        /*
        level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(Levels_Animals.this,Animals_Level2.class));
            }
        });
         */
    }
}